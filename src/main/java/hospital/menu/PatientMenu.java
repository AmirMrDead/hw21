package hospital.menu;

import hospital.entity.patient.Patient;
import hospital.util.PatientOperations;

import java.util.Scanner;

public class PatientMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(Patient patient) {
        while (true) {
            System.out.println("Welcome " + patient.getFirstname());
            System.out.println("1- Show my information");
            System.out.println("2- Show my previous medical information ");
            System.out.println("3- Getting an appointment ");
            System.out.println("4- Cancel my turn ");
            System.out.println("5- Exit ");
            System.out.print("Enter command: ");
            String command = scanner.next();
            if (command.equals("1")) {
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.showPersonalInformation(patient);
            } else if (command.equals("2")) {
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.showMedicalInformation(patient);
            } else if (command.equals("3")) {
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.getAnAppointment(patient);
            } else if (command.equals("4")) {
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.cancelTurn(patient);
            } else if (command.equals("5")) {
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

}
