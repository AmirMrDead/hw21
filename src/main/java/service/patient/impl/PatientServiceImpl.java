package service.patient.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.patient.Patient;
import repository.patient.impl.PatientRepositoryImpl;
import service.patient.PatientService;

public class PatientServiceImpl extends BaseServiceImpl<Patient> implements PatientService {
    @Override
    protected BaseRepository<Patient> getBaseRepository() {
        return new PatientRepositoryImpl();
    }
}
