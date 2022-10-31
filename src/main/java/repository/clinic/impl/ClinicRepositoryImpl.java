package repository.clinic.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.clinic.Clinic;
import repository.clinic.ClinicRepository;

public class ClinicRepositoryImpl extends BaseRepositoryImpl<Clinic> implements ClinicRepository {
    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
