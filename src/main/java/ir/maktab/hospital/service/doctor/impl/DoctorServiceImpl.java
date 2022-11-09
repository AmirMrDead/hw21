package ir.maktab.hospital.service.doctor.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.doctor.Doctor;
import ir.maktab.hospital.service.doctor.DoctorService;
import ir.maktab.hospital.repository.doctor.DoctorRepository;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorRepository> implements DoctorService {

    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
    }
}
