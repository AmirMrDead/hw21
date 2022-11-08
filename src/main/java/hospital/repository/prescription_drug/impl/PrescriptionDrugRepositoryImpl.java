package hospital.repository.prescription_drug.impl;

import hospital.entity.prescription_drug.PrescriptionDrug;
import hospital.entity.prescription_drug.PrescriptionDrugId;
import jakarta.persistence.EntityManager;
import hospital.repository.prescription_drug.PrescriptionDrugRepository;
import hospital.util.Hibernate;

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
