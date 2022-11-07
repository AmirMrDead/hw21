package util;

import entity.patient.Patient;

public class PatientOperations {

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

}
