package hospital.service.prescription_drug;

import hospital.entity.prescription_drug.PrescriptionDrug;
import hospital.entity.prescription_drug.PrescriptionDrugId;

import java.util.Optional;

public interface PrescriptionDrugService{

    void saveOrUpdate(PrescriptionDrug prescriptionDrug);
    Optional<PrescriptionDrug> loadById(PrescriptionDrugId id);
    void delete(PrescriptionDrug prescriptionDrug);

}
