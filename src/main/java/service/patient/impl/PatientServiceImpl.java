package service.patient.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.patient.Patient;
import repository.patient.PatientRepository;
import repository.patient.impl.PatientRepositoryImpl;
import service.patient.PatientService;

import java.util.Optional;

public class PatientServiceImpl extends BaseServiceImpl<Patient> implements PatientService {
    @Override
    protected BaseRepository<Patient> getBaseRepository() {
        return new PatientRepositoryImpl();
    }

    @Override
    public Optional<Patient> findByNationalCode(String nationalCode) {
        try {
            return ((PatientRepository) getBaseRepository()).findByNationalCode(nationalCode);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Patient> login(String nationalCode, String password) {
        try {
            return ((PatientRepository) getBaseRepository()).login(nationalCode, password);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
