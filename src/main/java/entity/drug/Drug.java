package entity.drug;

import base.entity.BaseEntity;
import entity.prescription.Prescription;
import entity.prescription_drug.PrescriptionDrug;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Drug extends BaseEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private DrugType type;
    private Double price;
    @OneToMany(mappedBy = "drug")
    private Set<PrescriptionDrug> prescriptionDrugs = new HashSet<>();

}
