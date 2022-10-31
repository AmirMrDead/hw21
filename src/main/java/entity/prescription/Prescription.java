package entity.prescription;

import base.entity.BaseEntity;
import entity.patient.Patient;
import entity.prescription_drug.PrescriptionDrug;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Prescription extends BaseEntity {

    @OneToOne(mappedBy = "prescription")
    private Patient patient;
    @OneToMany(mappedBy = "prescription")
    private Set<PrescriptionDrug> prescriptionDrugs  = new HashSet<>();

}
