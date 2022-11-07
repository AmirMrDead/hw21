package service.patient.impl;

import base.service.impl.BaseServiceImpl;
import entity.patient.Patient;
import repository.patient.PatientRepository;
import service.patient.PatientService;

import java.util.Optional;

public class PatientServiceImpl extends BaseServiceImpl<Patient,PatientRepository> implements PatientService {

    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Patient> findByNationalCode(String nationalCode) {
        try {
            return repository.findByNationalCode(nationalCode);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Patient> login(String nationalCode, String password) {
        try {
            return repository.login(nationalCode, password);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
