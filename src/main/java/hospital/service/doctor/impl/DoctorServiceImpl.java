package hospital.service.doctor.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.doctor.Doctor;
import hospital.repository.doctor.DoctorRepository;
import hospital.service.doctor.DoctorService;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorRepository> implements DoctorService {

    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
    }
}
