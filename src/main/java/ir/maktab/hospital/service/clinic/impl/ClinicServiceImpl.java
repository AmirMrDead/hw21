package ir.maktab.hospital.service.clinic.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.clinic.Clinic;
import ir.maktab.hospital.service.clinic.ClinicService;
import ir.maktab.hospital.repository.clinic.ClinicRepository;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, ClinicRepository> implements ClinicService {

    public ClinicServiceImpl(ClinicRepository repository) {
        super(repository);
    }
}