package hospital.entity.prescription_drug;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PrescriptionDrugId implements Serializable {

    private Long prescriptionId;
    private Long drugId;

}
