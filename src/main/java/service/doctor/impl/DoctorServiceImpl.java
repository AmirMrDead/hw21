package service.doctor.impl;

import base.service.impl.BaseServiceImpl;
import entity.doctor.Doctor;
import repository.doctor.DoctorRepository;
import service.doctor.DoctorService;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorRepository> implements DoctorService {

    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
    }
}
