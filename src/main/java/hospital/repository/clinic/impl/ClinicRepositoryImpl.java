package hospital.repository.clinic.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.clinic.Clinic;
import jakarta.persistence.EntityManager;
import hospital.repository.clinic.ClinicRepository;

public class ClinicRepositoryImpl extends BaseRepositoryImpl<Clinic> implements ClinicRepository {
    public ClinicRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
