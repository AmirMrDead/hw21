package service.prescription.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.prescription.Prescription;
import repository.prescription.impl.PrescriptionRepositoryImpl;
import service.prescription.PrescriptionService;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription> implements PrescriptionService {

    @Override
    protected BaseRepository<Prescription> getBaseRepository() {
        return new PrescriptionRepositoryImpl();
    }
}
