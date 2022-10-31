package repository.hospital.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.hospital.Hospital;
import repository.hospital.HospitalRepository;

public class HospitalRepositoryImpl extends BaseRepositoryImpl<Hospital> implements HospitalRepository {
    @Override
    public Class<Hospital> getEntityClass() {
        return Hospital.class;
    }
}
