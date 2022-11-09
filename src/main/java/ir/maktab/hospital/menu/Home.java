package ir.maktab.hospital.menu;

import ir.maktab.hospital.util.Validation;

import java.util.Objects;
import java.util.Scanner;

public class Home {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("Welcome to hospital");
            System.out.println("1- Login patient");
            System.out.println("2- Login admin");
            System.out.println("3- Register patient");
            System.out.println("4- Exit");
            System.out.print("Enter command: ");
            String command = scanner.next();
            if (Objects.equals(command, "1")) {
                Validation validation = new Validation();
                validation.loginMenu("patient");
            } else if (Objects.equals(command, "2")) {
                Validation validation = new Validation();
                validation.loginMenu("admin");
            } else if ((Objects.equals(command, "3"))) {
                Validation validation = new Validation();
                validation.signupMenu("patient");
            } else if ((Objects.equals(command, "4"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }

        }
    }

}
