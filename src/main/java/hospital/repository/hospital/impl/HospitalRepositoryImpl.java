package hospital.repository.hospital.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.hospital.Hospital;
import jakarta.persistence.EntityManager;
import hospital.repository.hospital.HospitalRepository;

public class HospitalRepositoryImpl extends BaseRepositoryImpl<Hospital> implements HospitalRepository {
    public HospitalRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Hospital> getEntityClass() {
        return Hospital.class;
    }
}
