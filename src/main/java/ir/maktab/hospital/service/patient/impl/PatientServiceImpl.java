package ir.maktab.hospital.service.patient.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.patient.Patient;
import ir.maktab.hospital.repository.patient.PatientRepository;
import ir.maktab.hospital.service.patient.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class PatientServiceImpl extends BaseServiceImpl<Patient, PatientRepository> implements PatientService {

    private static final Logger logger = LogManager.getLogger(PatientServiceImpl.class);
    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Patient> findByNationalCode(String nationalCode) {
        logger.info("find by national code");
        try {
            logger.debug("try to find patient with entered national code");
            return repository.findByNationalCode(nationalCode);
        } catch (Exception e) {
            logger.error("error in find patient with national code");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Patient> login(String nationalCode, String password) {
        logger.info("login patient");
        try {
            logger.debug("tru to login patient");
            return repository.login(nationalCode, password);
        } catch (Exception e) {
            logger.error("error in patient login");
            return Optional.empty();
        }
    }
}
