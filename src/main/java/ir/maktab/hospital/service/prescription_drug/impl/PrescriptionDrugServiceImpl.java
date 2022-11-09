package ir.maktab.hospital.service.prescription_drug.impl;

import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrug;
import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrugId;
import ir.maktab.hospital.service.prescription_drug.PrescriptionDrugService;
import ir.maktab.hospital.repository.prescription_drug.PrescriptionDrugRepository;
import ir.maktab.hospital.repository.prescription_drug.impl.PrescriptionDrugRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class PrescriptionDrugServiceImpl implements PrescriptionDrugService {

    private static final Logger logger = LogManager.getLogger(PrescriptionDrugServiceImpl.class);
    private final PrescriptionDrugRepository prescriptionDrugRepository = new PrescriptionDrugRepositoryImpl();

    @Override
    public void saveOrUpdate(PrescriptionDrug prescriptionDrug) {
        logger.info("save or update prescriptionDrug");
        prescriptionDrugRepository.saveOrUpdate(prescriptionDrug);
    }

    @Override
    public Optional<PrescriptionDrug> loadById(PrescriptionDrugId id) {
        logger.info("load prescriptionDrug by id");
        return prescriptionDrugRepository.loadById(id);
    }

    @Override
    public void delete(PrescriptionDrug prescriptionDrug) {
        logger.info("delete prescriptionDrug");
        prescriptionDrugRepository.delete(prescriptionDrug);
    }
}
