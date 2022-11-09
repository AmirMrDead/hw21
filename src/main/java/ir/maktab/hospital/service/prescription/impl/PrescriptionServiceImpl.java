package ir.maktab.hospital.service.prescription.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.prescription.Prescription;
import ir.maktab.hospital.service.prescription.PrescriptionService;
import ir.maktab.hospital.repository.prescription.PrescriptionRepository;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription, PrescriptionRepository> implements PrescriptionService {


    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        super(repository);
    }
}
