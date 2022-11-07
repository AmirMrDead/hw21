package service.hospital.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.hospital.Hospital;
import repository.hospital.HospitalRepository;
import repository.hospital.impl.HospitalRepositoryImpl;
import service.hospital.HospitalService;
import util.Hibernate;

public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalRepository> implements HospitalService {

    public HospitalServiceImpl(HospitalRepository repository) {
        super(repository);
    }
}
