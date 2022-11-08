package hospital.repository.prescription_drug;

import hospital.entity.prescription_drug.PrescriptionDrug;
import hospital.entity.prescription_drug.PrescriptionDrugId;

import java.util.Optional;

public interface PrescriptionDrugRepository{

    void saveOrUpdate(PrescriptionDrug prescriptionDrug);
    Optional<PrescriptionDrug> loadById(PrescriptionDrugId id);
    void delete(PrescriptionDrug prescriptionDrug);

}
