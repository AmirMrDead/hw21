package repository.clinic.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.clinic.Clinic;
import jakarta.persistence.EntityManager;
import repository.clinic.ClinicRepository;

public class ClinicRepositoryImpl extends BaseRepositoryImpl<Clinic> implements ClinicRepository {
    public ClinicRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
