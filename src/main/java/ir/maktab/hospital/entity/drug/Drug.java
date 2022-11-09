package ir.maktab.hospital.entity.drug;

import ir.maktab.hospital.base.entity.BaseEntity;
import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrug;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Drug extends BaseEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private DrugType type;
    private Double price;
    @OneToMany(mappedBy = "drug",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<PrescriptionDrug> prescriptionDrugs = new HashSet<>();

}
