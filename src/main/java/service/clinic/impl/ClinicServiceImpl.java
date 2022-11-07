package service.clinic.impl;

import base.service.impl.BaseServiceImpl;
import entity.clinic.Clinic;
import repository.clinic.ClinicRepository;
import service.clinic.ClinicService;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, ClinicRepository> implements ClinicService {

    public ClinicServiceImpl(ClinicRepository repository) {
        super(repository);
    }
}