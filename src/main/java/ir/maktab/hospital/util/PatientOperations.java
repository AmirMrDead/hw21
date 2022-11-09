package ir.maktab.hospital.util;

import ir.maktab.hospital.entity.patient.Patient;
import ir.maktab.hospital.entity.turn.Turn;
import ir.maktab.hospital.repository.turn.impl.TurnRepositoryImpl;
import ir.maktab.hospital.service.turn.TurnService;
import ir.maktab.hospital.service.turn.impl.TurnServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatientOperations {

    private final Scanner scanner = new Scanner(System.in);
    private static final Logger logger= LogManager.getLogger(PatientOperations.class);

    public void showPersonalInformation(Patient patient) {
        logger.info("show personal patients information");
        System.out.println("firstname: " + patient.getFirstname());
        System.out.println("lastname: " + patient.getLastname());
        System.out.println("national code: " + patient.getNationalCode());
    }

    public void showMedicalInformation(Patient patient) {
        logger.info("show personal medicals patients information");
        patient.getPrescriptions().forEach(prescription -> {
            System.out.print("Id: " + prescription.getId() + " drugs: ");
            prescription.getPrescriptionDrugs().forEach(prescriptionDrug -> System.out.print(prescriptionDrug.getDrug() + " - "));
            System.out.println("\n-------------------------");
        });
    }

    public void getAnAppointment(Patient patient) {
        logger.info("show personal information");
        ClinicOperations clinicOperations = new ClinicOperations();
        clinicOperations.showAll(patient);
    }

    public void cancelTurn(Patient patient){
        logger.debug("cancel turns for patient");
        TurnService turnService = new TurnServiceImpl(new TurnRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        List<Turn> turns = turnService.loadTurnByPatient(patient.getId());
        turns.forEach(turn -> System.out.println("id: " + turn.getId() + " " + turn));
        Validation validation = new Validation();
        System.out.print("Enter id: ");
        Long id = validation.validNumber(scanner.next());
        Optional<Turn> optionalTurn = turnService.loadById(id);
        optionalTurn.ifPresentOrElse(turn -> {
            if(turn.getPatient().getId() == patient.getId()){
                turn.setIsCancel(true);
                turnService.saveOrUpdate(turn);
                System.out.println("Done");
            }
        },() -> {
            System.out.println("This turn is not for you");
        });
    }
}
