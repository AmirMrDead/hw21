package repository.prescription.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.prescription.Prescription;
import repository.prescription.PrescriptionRepository;

public class PrescriptionRepositoryImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepository {
    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }
}
