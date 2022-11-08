package hospital.entity.prescription;

import hospital.base.entity.BaseEntity;
import hospital.entity.patient.Patient;
import hospital.entity.prescription_drug.PrescriptionDrug;
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
public class Prescription extends BaseEntity {

    @ManyToOne
    @ToString.Exclude
    private Patient patient;
    @OneToMany(mappedBy = "prescription",cascade = CascadeType.ALL)
    private Set<PrescriptionDrug> prescriptionDrugs  = new HashSet<>();

}
