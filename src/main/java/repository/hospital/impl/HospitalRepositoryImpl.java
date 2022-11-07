package repository.hospital.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.hospital.Hospital;
import jakarta.persistence.EntityManager;
import repository.hospital.HospitalRepository;

public class HospitalRepositoryImpl extends BaseRepositoryImpl<Hospital> implements HospitalRepository {
    public HospitalRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Hospital> getEntityClass() {
        return Hospital.class;
    }
}
