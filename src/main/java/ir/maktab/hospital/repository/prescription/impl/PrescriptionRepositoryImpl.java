package ir.maktab.hospital.repository.prescription.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.prescription.Prescription;
import ir.maktab.hospital.repository.prescription.PrescriptionRepository;
import jakarta.persistence.EntityManager;

public class PrescriptionRepositoryImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepository {
    public PrescriptionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }
}
