package repository.patient.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.patient.Patient;
import repository.patient.PatientRepository;

public class PatientRepositoryImpl extends BaseRepositoryImpl<Patient> implements PatientRepository {
    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }
}
