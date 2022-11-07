package util;

import entity.patient.Patient;
import menu.PatientMenu;
import repository.patient.impl.PatientRepositoryImpl;
import service.patient.PatientService;
import service.patient.impl.PatientServiceImpl;

import java.util.Optional;
import java.util.Scanner;

public class Validation {

    private final Scanner scanner = new Scanner(System.in);
    PatientService patientService = new PatientServiceImpl(
            new PatientRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void loginMenu(String type) {
        System.out.print("Enter your national code: ");
        String nationalCode = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        if(type.equalsIgnoreCase("patient")){
            Optional<Patient> optionalUser = patientService.login(nationalCode, password);
            optionalUser.ifPresentOrElse(user -> {
                PatientMenu patientMenu = new PatientMenu();
                patientMenu.showMenu(user);
            }, () -> System.out.println("Wrong information"));
        }
    }

    public void signupMenu(String type) {
        System.out.print("Enter your firstname: ");
        String firstname = validName(scanner.next());
        System.out.print("Enter your lastname: ");
        String lastname = validName(scanner.next());
        System.out.print("Enter your nationalCode: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        if(type.equalsIgnoreCase("patient")){
            Patient patient = new Patient(firstname, lastname, username, password);
            System.out.println("aa");
            patientService.saveOrUpdate(patient);
        }
    }

    public Long validNumber(String number) {
        long value;
        while (true) {
            try {
                value = Long.parseLong(number);
                if (value < 0) {
                    System.out.println("number cant be negative");
                    number = scanner.next();
                    continue;
                }
            } catch (Exception e) {
                System.out.print("Wrong number input. Enter again: ");
                number = scanner.next();
                continue;
            }
            break;
        }
        return value;
    }

    private String validName(String name) {
        boolean check;
        while (true) {
            if (name.length() < 3 || name.length() > 15) {
                System.out.print("Name must between 3 and 15 character. Enter again: ");
                name = scanner.next();
                continue;
            }
            check = false;
            for (Character character : name.toCharArray()) {
                if (Character.isDigit(character)) {
                    System.out.print("Name cant have number. Enter again: ");
                    name = scanner.next();
                    check = true;
                    break;
                }
            }
            if (!check) return name;
        }
    }

    private String checkExistNationalCode(String nationalCode) {
        while (true) {
            Optional<Patient> optionalUser = patientService.findByNationalCode(nationalCode);
            if (optionalUser.isPresent()) {
                System.out.print("This national code exist. choose another one: ");
                nationalCode = scanner.next();
            } else {
                return nationalCode;
            }
        }
    }

}
