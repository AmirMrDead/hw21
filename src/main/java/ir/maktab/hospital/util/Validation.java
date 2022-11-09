package ir.maktab.hospital.util;

import ir.maktab.hospital.entity.admin.Admin;
import ir.maktab.hospital.entity.patient.Patient;
import ir.maktab.hospital.repository.admin.impl.AdminRepositoryImpl;
import ir.maktab.hospital.repository.patient.impl.PatientRepositoryImpl;
import ir.maktab.hospital.service.patient.PatientService;
import ir.maktab.hospital.menu.AdminMenu;
import ir.maktab.hospital.menu.PatientMenu;
import ir.maktab.hospital.service.admin.AdminService;
import ir.maktab.hospital.service.admin.impl.AdminServiceImpl;
import ir.maktab.hospital.service.patient.impl.PatientServiceImpl;

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
            Optional<Patient> optionalPatient = patientService.login(nationalCode, password);
            optionalPatient.ifPresentOrElse(patient -> {
                PatientMenu patientMenu = new PatientMenu();
                patientMenu.showMenu(patient);
            }, () -> System.out.println("Wrong information"));
        } else if(type.equalsIgnoreCase("admin")){
            AdminService adminService = new AdminServiceImpl(new AdminRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
            Optional<Admin> optionalAdmin = adminService.login(nationalCode, password);
            optionalAdmin.ifPresentOrElse(admin -> {
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.showMenu(admin);
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
