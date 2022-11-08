package hospital.menu;

import hospital.entity.admin.Admin;
import hospital.util.AdminOperations;

import java.util.Scanner;

public class AdminMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(Admin admin){
        while(true){
            System.out.println("Welcome " + admin.getFirstname());
            System.out.println("1- Show patients information");
            System.out.println("2- Show turns");
            System.out.println("3- Delete canceled turns");
            System.out.println("4- Exit");
            System.out.print("Enter command: ");
            String command = scanner.next();
            if(command.equals("1")){
                AdminOperations adminOperations = new AdminOperations();
                adminOperations.showPatientInformation();
            } else if(command.equals("2")){
                AdminOperations adminOperations = new AdminOperations();
                adminOperations.showTurns();
            } else if(command.equals("3")){
                AdminOperations adminOperations = new AdminOperations();
                adminOperations.deleteCanceledTurns();
            } else if(command.equals("4")){
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

}
