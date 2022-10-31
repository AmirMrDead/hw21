package service.clinic.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.clinic.Clinic;
import repository.clinic.impl.ClinicRepositoryImpl;
import service.clinic.ClinicService;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic> implements ClinicService {
    @Override
    protected BaseRepository<Clinic> getBaseRepository() {
        return new ClinicRepositoryImpl();
    }
}