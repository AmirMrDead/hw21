package repository.doctor.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.doctor.DoctorTime;
import repository.doctor.DoctorTimeRepository;

public class DoctorTimeRepositoryImpl extends BaseRepositoryImpl<DoctorTime> implements DoctorTimeRepository {
    @Override
    public Class<DoctorTime> getEntityClass() {
        return DoctorTime.class;
    }
}
