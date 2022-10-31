package service.hospital.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.hospital.Hospital;
import repository.hospital.impl.HospitalRepositoryImpl;
import service.hospital.HospitalService;

public class HospitalServiceImpl extends BaseServiceImpl<Hospital> implements HospitalService {
    @Override
    protected BaseRepository<Hospital> getBaseRepository() {
        return new HospitalRepositoryImpl();
    }
}
