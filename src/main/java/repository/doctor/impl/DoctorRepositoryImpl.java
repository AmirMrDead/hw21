package repository.doctor.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.doctor.Doctor;
import jakarta.persistence.EntityManager;
import repository.doctor.DoctorRepository;

public class DoctorRepositoryImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepository {
    public DoctorRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
