package util;

import entity.clinic.Clinic;
import entity.doctor.Doctor;
import entity.doctor.DoctorTime;
import entity.patient.Patient;
import entity.turn.Turn;
import repository.clinic.impl.ClinicRepositoryImpl;
import repository.doctor.impl.DoctorRepositoryImpl;
import repository.doctor.impl.DoctorTimeRepositoryImpl;
import repository.turn.impl.TurnRepositoryImpl;
import service.clinic.ClinicService;
import service.clinic.impl.ClinicServiceImpl;
import service.doctor.DoctorService;
import service.doctor.DoctorTimeService;
import service.doctor.impl.DoctorServiceImpl;
import service.doctor.impl.DoctorTimeServiceImpl;
import service.turn.TurnService;
import service.turn.impl.TurnServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
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
        List<Clinic> clinics = showClinics();
        Clinic clinic = chooseClinic(validation);
        if (clinic == null) return;
        showDoctors(clinic);
        System.out.print("Choose one of our doctors( 0 for exit): ");
        Long doctorId = validation.validNumber(scanner.next());
        if (doctorId == null) return;
        getAnAppointment(patient, clinic, doctorId);
    }

    private void getAnAppointment(Patient patient, Clinic clinic, Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorService.loadById(doctorId);
        if (isDoctorExist(clinic, optionalDoctor)) return;
        LocalDate localDate = LocalDate.now().plusDays(1L);
        boolean check = false;
        List<DoctorTime> doctorTimes = doctorTimeService.loadByDoctorId(doctorId);
        while (true) {
            for (DoctorTime doctorTime : doctorTimes) {
                if (localDate.getDayOfWeek().toString().equalsIgnoreCase(doctorTime.getDay().toString())) {
                    List<Turn> turns = turnService.loadByDate(localDate, 1L);
                    LocalDateTime newTime;
                    newTime = setAppointment(localDate, doctorTime, turns);
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

    private static boolean isDoctorExist(Clinic clinic, Optional<Doctor> optionalDoctor) {
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

    private static LocalDateTime setAppointment(LocalDate localDate, DoctorTime doctorTime, List<Turn> turns) {
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

    private static void showDoctors(Clinic clinic) {
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

    private List<Clinic> showClinics() {
        List<Clinic> clinics = clinicService.loadAll();
        for (int i = 0; i < clinics.size(); i++) {
            System.out.println((i + 1) + "- " + clinics.get(i).getName());
        }
        System.out.print("Choose one of our clinics( 0 for exit): ");
        return clinics;
    }

}
