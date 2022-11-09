package ir.maktab.hospital.repository.doctor.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.doctor.Doctor;
import ir.maktab.hospital.repository.doctor.DoctorRepository;
import jakarta.persistence.EntityManager;

public class DoctorRepositoryImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepository {
    public DoctorRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
