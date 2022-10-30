package entity.prescription;

import base.entity.BaseEntity;
import entity.drug.Drug;
import entity.patient.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Prescription extends BaseEntity {

    @OneToOne(mappedBy = "prescription")
    private Patient patient;
    @ManyToMany
    private Set<Drug> drugs = new HashSet<>();

}
