package hospital.service.prescription_drug.impl;

import hospital.entity.prescription_drug.PrescriptionDrug;
import hospital.entity.prescription_drug.PrescriptionDrugId;
import hospital.repository.prescription_drug.PrescriptionDrugRepository;
import hospital.repository.prescription_drug.impl.PrescriptionDrugRepositoryImpl;
import hospital.service.prescription_drug.PrescriptionDrugService;

import java.util.Optional;

public class PrescriptionDrugServiceImpl implements PrescriptionDrugService {

    private final PrescriptionDrugRepository prescriptionDrugRepository = new PrescriptionDrugRepositoryImpl();

    @Override
    public void saveOrUpdate(PrescriptionDrug prescriptionDrug) {
        prescriptionDrugRepository.saveOrUpdate(prescriptionDrug);
    }

    @Override
    public Optional<PrescriptionDrug> loadById(PrescriptionDrugId id) {
        return prescriptionDrugRepository.loadById(id);
    }

    @Override
    public void delete(PrescriptionDrug prescriptionDrug) {
        prescriptionDrugRepository.delete(prescriptionDrug);
    }
}
