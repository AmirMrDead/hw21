package repository.prescription.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.prescription.Prescription;
import jakarta.persistence.EntityManager;
import repository.prescription.PrescriptionRepository;

public class PrescriptionRepositoryImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepository {
    public PrescriptionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }
}
