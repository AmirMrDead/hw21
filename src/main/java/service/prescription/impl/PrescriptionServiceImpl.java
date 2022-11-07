package service.prescription.impl;

import base.service.impl.BaseServiceImpl;
import entity.prescription.Prescription;
import repository.prescription.PrescriptionRepository;
import service.prescription.PrescriptionService;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription, PrescriptionRepository> implements PrescriptionService {


    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        super(repository);
    }
}
