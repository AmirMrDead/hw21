package ir.maktab.hospital.repository.clinic.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.clinic.Clinic;
import ir.maktab.hospital.repository.clinic.ClinicRepository;
import jakarta.persistence.EntityManager;

public class ClinicRepositoryImpl extends BaseRepositoryImpl<Clinic> implements ClinicRepository {
    public ClinicRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
