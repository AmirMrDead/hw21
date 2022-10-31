package service.doctor.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.doctor.DoctorTime;
import repository.doctor.impl.DoctorTimeRepositoryImpl;
import service.doctor.DoctorTimeService;

public class DoctorTimeServiceImpl extends BaseServiceImpl<DoctorTime> implements DoctorTimeService {
    @Override
    protected BaseRepository<DoctorTime> getBaseRepository() {
        return new DoctorTimeRepositoryImpl();
    }
}
