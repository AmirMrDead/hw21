package ir.maktab.hospital.util;

import ir.maktab.hospital.entity.clinic.Clinic;
import ir.maktab.hospital.entity.doctor.Doctor;
import ir.maktab.hospital.entity.doctor.DoctorTime;
import ir.maktab.hospital.entity.patient.Patient;
import ir.maktab.hospital.entity.turn.Turn;
import ir.maktab.hospital.repository.clinic.impl.ClinicRepositoryImpl;
import ir.maktab.hospital.repository.doctor.impl.DoctorRepositoryImpl;
import ir.maktab.hospital.repository.doctor.impl.DoctorTimeRepositoryImpl;
import ir.maktab.hospital.repository.turn.impl.TurnRepositoryImpl;
import ir.maktab.hospital.service.clinic.ClinicService;
import ir.maktab.hospital.service.clinic.impl.ClinicServiceImpl;
import ir.maktab.hospital.service.doctor.DoctorService;
import ir.maktab.hospital.service.doctor.DoctorTimeService;
import ir.maktab.hospital.service.doctor.impl.DoctorServiceImpl;
import ir.maktab.hospital.service.doctor.impl.DoctorTimeServiceImpl;
import ir.maktab.hospital.service.turn.TurnService;
import ir.maktab.hospital.service.turn.impl.TurnServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class ClinicOperations {

    private final ClinicService clinicService = new ClinicServiceImpl(
            new ClinicRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorTimeService doctorTimeService = new DoctorTimeServiceImpl(
            new DoctorTimeRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorService doctorService = new DoctorServiceImpl(
            new DoctorRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final TurnService turnService = new TurnServiceImpl(
            new TurnRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(ClinicOperations.class);

    public void showAll(Patient patient) {
        Validation validation = new Validation();
        logger.debug("show clinics");
        showClinics();
        logger.debug("choose clinics");
        Clinic clinic = chooseClinic(validation);
        if (clinic == null) return;
        logger.debug("show doctors");
        showDoctors(clinic);
        logger.debug("choose doctors");
        System.out.print("Choose one of our doctors( 0 for exit): ");
        Long doctorId = validation.validNumber(scanner.next());
        if (doctorId == null) return;
        logger.debug("get appointment");
        getAnAppointment(patient, clinic, doctorId);
    }

    private void getAnAppointment(Patient patient, Clinic clinic, Long doctorId) {
        logger.debug("check exist turns");
        List<Turn> turns = turnService.loadTurnByPatient(patient.getId());
        boolean checkTurnExist = checkTurnExist(patient, doctorId, turns);
        if (checkTurnExist) return;
        logger.debug("check exist doctor");
        Optional<Doctor> optionalDoctor = doctorService.loadById(doctorId);
        if (isDoctorExist(clinic, optionalDoctor)) return;
        logger.debug("set appointment for patient");
        LocalDate localDate = LocalDate.now().plusDays(1L);
        boolean check = false;
        List<DoctorTime> doctorTimes = doctorTimeService.loadByDoctorId(doctorId);
        while (true) {
            for (DoctorTime doctorTime : doctorTimes) {
                if (localDate.getDayOfWeek().toString().equalsIgnoreCase(doctorTime.getDay().toString())) {
                    List<Turn> beforeTurns = turnService.loadByDate(localDate, 1L);
                    LocalDateTime newTime;
                    newTime = setAppointment(localDate, doctorTime, beforeTurns);
                    if (newTime == null) break;
                    saveTurn(patient, optionalDoctor.get(), newTime);
                    check = true;
                }
            }
            localDate = localDate.plusDays(1L);
            if (check)
                break;
        }
    }

    private static boolean checkTurnExist(Patient patient, Long doctorId, List<Turn> turns) {
        boolean checkTurnExist = false;
        for (Turn turn : turns) {
            if (Objects.equals(turn.getPatient().getId(), patient.getId()) && Objects.equals(turn.getDoctor().getId(), doctorId)) {
                System.out.println("You have turn with this doctor");
                checkTurnExist = true;
            }
        }
        return checkTurnExist;
    }

    private boolean isDoctorExist(Clinic clinic, Optional<Doctor> optionalDoctor) {
        if (optionalDoctor.isEmpty()) {
            System.out.println("Our hospital does not have doctor with id entered");
            return true;
        }
        if (!clinic.getDoctors().contains(optionalDoctor.get())) {
            System.out.println("This clinic does not have doctor with id entered");
            return true;
        }
        return false;
    }

    private void saveTurn(Patient patient, Doctor doctor, LocalDateTime newTime) {
        logger.debug("save turn");
        Turn turn = new Turn(patient, doctor, newTime, false);
        turnService.saveOrUpdate(turn);
    }

    private LocalDateTime setAppointment(LocalDate localDate, DoctorTime doctorTime, List<Turn> turns) {
        LocalDateTime newTime;
        if (turns.isEmpty()) {
            newTime = LocalDateTime.of(localDate, LocalTime.of(doctorTime.getStartTime().getHour()
                    , doctorTime.getStartTime().getMinute()));
        } else {
            newTime = turns.get(turns.size() - 1).getTime().plusMinutes(doctorTime.getDuringTime());
            if (newTime.getHour() > doctorTime.getEndTime().getHour() &&
                    newTime.getMinute() > doctorTime.getEndTime().getMinute()) {
                return null;
            }
        }
        return newTime;
    }

    private void showDoctors(Clinic clinic) {
        for (Doctor doctor : clinic.getDoctors()) {
            System.out.println(doctor);
        }
    }

    private Clinic chooseClinic(Validation validation) {
        Long clinicId = validation.validNumber(scanner.next());
        Optional<Clinic> optionalClinic = clinicService.loadById(clinicId);
        if (optionalClinic.isEmpty()) {
            System.out.println("Our hospital does not have clinic with id entered");
            return null;
        }
        if (clinicId == 0)
            return null;
        return optionalClinic.get();
    }

    private void showClinics() {
        List<Clinic> clinics = clinicService.loadAll();
        for (int i = 0; i < clinics.size(); i++) {
            System.out.println((i + 1) + "- " + clinics.get(i).getName());
        }
        System.out.print("Choose one of our clinics( 0 for exit): ");
    }

}
