package ir.maktab.hospital.repository.hospital.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.hospital.Hospital;
import ir.maktab.hospital.repository.hospital.HospitalRepository;
import jakarta.persistence.EntityManager;

public class HospitalRepositoryImpl extends BaseRepositoryImpl<Hospital> implements HospitalRepository {
    public HospitalRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Hospital> getEntityClass() {
        return Hospital.class;
    }
}
