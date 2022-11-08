package hospital.repository.prescription.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.prescription.Prescription;
import jakarta.persistence.EntityManager;
import hospital.repository.prescription.PrescriptionRepository;

public class PrescriptionRepositoryImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepository {
    public PrescriptionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }
}
