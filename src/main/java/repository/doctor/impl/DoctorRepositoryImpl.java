package repository.doctor.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.doctor.Doctor;
import repository.doctor.DoctorRepository;

public class DoctorRepositoryImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepository {
    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
