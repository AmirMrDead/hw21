package service.doctor.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.doctor.Doctor;
import repository.doctor.impl.DoctorRepositoryImpl;
import service.doctor.DoctorService;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor> implements DoctorService {
    @Override
    protected BaseRepository<Doctor> getBaseRepository() {
        return new DoctorRepositoryImpl();
    }
}
