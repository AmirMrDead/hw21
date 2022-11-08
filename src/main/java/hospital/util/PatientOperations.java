package hospital.util;

import hospital.entity.patient.Patient;
import hospital.entity.turn.Turn;
import hospital.repository.turn.impl.TurnRepositoryImpl;
import hospital.service.turn.TurnService;
import hospital.service.turn.impl.TurnServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatientOperations {

    private final Scanner scanner = new Scanner(System.in);

    public void showPersonalInformation(Patient patient) {
        System.out.println("firstname: " + patient.getFirstname());
        System.out.println("lastname: " + patient.getLastname());
        System.out.println("national code: " + patient.getNationalCode());
    }

    public void showMedicalInformation(Patient patient) {
        patient.getPrescriptions().forEach(prescription -> {
            System.out.print("Id: " + prescription.getId() + " drugs: ");
            prescription.getPrescriptionDrugs().forEach(prescriptionDrug -> System.out.print(prescriptionDrug.getDrug() + " - "));
            System.out.println("\n-------------------------");
        });
    }

    public void getAnAppointment(Patient patient) {
        ClinicOperations clinicOperations = new ClinicOperations();
        clinicOperations.showAll(patient);
    }

    public void cancelTurn(Patient patient){
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
