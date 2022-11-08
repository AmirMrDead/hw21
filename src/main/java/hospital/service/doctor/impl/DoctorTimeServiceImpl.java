package hospital.service.doctor.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.doctor.DoctorTime;
import hospital.repository.doctor.DoctorTimeRepository;
import hospital.service.doctor.DoctorTimeService;

import java.util.List;

public class DoctorTimeServiceImpl extends BaseServiceImpl<DoctorTime, DoctorTimeRepository> implements DoctorTimeService {


    public DoctorTimeServiceImpl(DoctorTimeRepository repository) {
        super(repository);
    }

    @Override
    public List<DoctorTime> loadByDoctorId(Long id) {
        return repository.loadByDoctorId(id);
    }
}
