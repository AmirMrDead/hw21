package ir.maktab.hospital.service.hospital.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.hospital.Hospital;
import ir.maktab.hospital.service.hospital.HospitalService;
import ir.maktab.hospital.repository.hospital.HospitalRepository;

public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalRepository> implements HospitalService {

    public HospitalServiceImpl(HospitalRepository repository) {
        super(repository);
    }
}
