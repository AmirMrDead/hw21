package hospital.util;

import hospital.entity.clinic.Clinic;
import hospital.entity.doctor.Doctor;
import hospital.entity.doctor.DoctorTime;
import hospital.entity.patient.Patient;
import hospital.entity.turn.Turn;
import hospital.repository.clinic.impl.ClinicRepositoryImpl;
import hospital.repository.doctor.impl.DoctorRepositoryImpl;
import hospital.repository.doctor.impl.DoctorTimeRepositoryImpl;
import hospital.repository.turn.impl.TurnRepositoryImpl;
import hospital.service.clinic.ClinicService;
import hospital.service.clinic.impl.ClinicServiceImpl;
import hospital.service.doctor.DoctorService;
import hospital.service.doctor.DoctorTimeService;
import hospital.service.doctor.impl.DoctorServiceImpl;
import hospital.service.doctor.impl.DoctorTimeServiceImpl;
import hospital.service.turn.TurnService;
import hospital.service.turn.impl.TurnServiceImpl;

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

    public void showAll(Patient patient) {
        Validation validation = new Validation();
        showClinics();
        Clinic clinic = chooseClinic(validation);
        if (clinic == null) return;
        showDoctors(clinic);
        System.out.print("Choose one of our doctors( 0 for exit): ");
        Long doctorId = validation.validNumber(scanner.next());
        if (doctorId == null) return;
        getAnAppointment(patient, clinic, doctorId);
    }

    private void getAnAppointment(Patient patient, Clinic clinic, Long doctorId) {
        List<Turn> turns = turnService.loadTurnByPatient(patient.getId());
        boolean checkTurnExist = checkTurnExist(patient, doctorId, turns);
        if (checkTurnExist) return;
        Optional<Doctor> optionalDoctor = doctorService.loadById(doctorId);
        if (isDoctorExist(clinic, optionalDoctor)) return;
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
