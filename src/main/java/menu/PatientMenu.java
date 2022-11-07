package menu;

import entity.patient.Patient;
import util.PatientOperations;

import java.util.Scanner;

public class PatientMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(Patient patient){
        while(true){
            System.out.println("Welcome " + patient.getFirstname());
            System.out.println("1- Show my information");
            System.out.println("2- Show my previous medical information ");
            System.out.println("3- Getting an appointment ");
            System.out.println("4- Exit ");
            String command = scanner.next();
            if(command.equalsIgnoreCase("1")){
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.showPersonalInformation(patient);
            } else if(command.equalsIgnoreCase("2")){
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.showMedicalInformation(patient);
            } else if(command.equalsIgnoreCase("3")){
                PatientOperations patientOperations = new PatientOperations();
                patientOperations.getAnAppointment(patient);
            } else if(command.equalsIgnoreCase("4")){
                break;
            } else {

            }
        }
    }

}
