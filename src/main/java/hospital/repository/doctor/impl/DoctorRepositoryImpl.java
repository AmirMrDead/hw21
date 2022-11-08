package hospital.repository.doctor.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.doctor.Doctor;
import jakarta.persistence.EntityManager;
import hospital.repository.doctor.DoctorRepository;

public class DoctorRepositoryImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepository {
    public DoctorRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
