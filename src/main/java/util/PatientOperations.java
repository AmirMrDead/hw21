package util;

import entity.patient.Patient;

public class PatientOperations {

    public void showInformation(Patient patient){
        System.out.println("firstname: " + patient.getFirstname());
        System.out.println("lastname: " + patient.getLastname());
        System.out.println("national code: " + patient.getNationalCode());
    }

    public void showInformation2(Patient patient){
        patient.getPrescriptions().forEach(prescription -> {
            System.out.print("Id: " + prescription.getId() + "drugs: ");
            prescription.getPrescriptionDrugs().forEach(prescriptionDrug -> {
                System.out.print(prescriptionDrug.getDrug() + "-");
            });
            System.out.println("-------------------------");
        });
    }

}
