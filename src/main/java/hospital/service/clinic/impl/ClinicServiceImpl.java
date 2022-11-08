package hospital.service.clinic.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.clinic.Clinic;
import hospital.repository.clinic.ClinicRepository;
import hospital.service.clinic.ClinicService;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, ClinicRepository> implements ClinicService {

    public ClinicServiceImpl(ClinicRepository repository) {
        super(repository);
    }
}