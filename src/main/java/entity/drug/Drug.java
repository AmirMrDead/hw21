package entity.drug;

import base.entity.BaseEntity;
import entity.prescription.Prescription;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Drug extends BaseEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private DrugType type;
    private Double price;
    @ManyToMany(mappedBy = "drugs")
    private Set<Prescription> prescriptions = new HashSet<>();

}
