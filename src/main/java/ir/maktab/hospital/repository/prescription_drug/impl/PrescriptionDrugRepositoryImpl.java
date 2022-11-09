package ir.maktab.hospital.repository.prescription_drug.impl;

import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrug;
import ir.maktab.hospital.entity.prescription_drug.PrescriptionDrugId;
import ir.maktab.hospital.repository.prescription_drug.PrescriptionDrugRepository;
import ir.maktab.hospital.util.Hibernate;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class PrescriptionDrugRepositoryImpl implements PrescriptionDrugRepository {

    protected final EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();

    @Override
    public void saveOrUpdate(PrescriptionDrug prescriptionDrug) {
        if (prescriptionDrug.getPrescriptionDrugId() == null) {
            em.persist(prescriptionDrug);
        } else {
            em.merge(prescriptionDrug);
        }
    }

    @Override
    public Optional<PrescriptionDrug> loadById(PrescriptionDrugId id) {
        return Optional.ofNullable(em.find(PrescriptionDrug.class, id));
    }

    @Override
    public void delete(PrescriptionDrug prescriptionDrug) {
        em.remove(prescriptionDrug);
    }
}
