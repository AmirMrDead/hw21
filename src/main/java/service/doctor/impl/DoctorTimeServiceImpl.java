package service.doctor.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.doctor.DoctorTime;
import repository.doctor.DoctorTimeRepository;
import repository.doctor.impl.DoctorTimeRepositoryImpl;
import service.doctor.DoctorTimeService;
import util.Hibernate;

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
