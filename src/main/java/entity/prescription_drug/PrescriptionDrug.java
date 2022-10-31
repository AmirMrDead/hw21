package entity.prescription_drug;

import entity.drug.Drug;
import entity.prescription.Prescription;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PrescriptionDrug{

    @EmbeddedId
    private PrescriptionDrugId prescriptionDrugId = new PrescriptionDrugId();
    @ManyToOne
    @MapsId("prescriptionId")
    private Prescription prescription;
    @ManyToOne
    @MapsId("drugId")
    private Drug drug;

}
