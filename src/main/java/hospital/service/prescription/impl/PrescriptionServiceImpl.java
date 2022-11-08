package hospital.service.prescription.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.prescription.Prescription;
import hospital.repository.prescription.PrescriptionRepository;
import hospital.service.prescription.PrescriptionService;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription, PrescriptionRepository> implements PrescriptionService {


    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        super(repository);
    }
}
