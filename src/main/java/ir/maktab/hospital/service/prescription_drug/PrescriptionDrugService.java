package ir.maktab.hospital.service.prescription_drug;

import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrug;
import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrugId;

import java.util.Optional;

public interface PrescriptionDrugService{

    void saveOrUpdate(PrescriptionDrug prescriptionDrug);
    Optional<PrescriptionDrug> loadById(PrescriptionDrugId id);
    void delete(PrescriptionDrug prescriptionDrug);

}
