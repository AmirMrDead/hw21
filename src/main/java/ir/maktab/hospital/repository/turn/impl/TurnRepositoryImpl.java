package ir.maktab.hospital.repository.turn.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.turn.Turn;
import ir.maktab.hospital.repository.turn.TurnRepository;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class TurnRepositoryImpl extends BaseRepositoryImpl<Turn> implements TurnRepository {

    private static final Logger logger = LogManager.getLogger(TurnRepositoryImpl.class);
    public TurnRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Turn> getEntityClass() {
        return Turn.class;
    }

    @Override
    public List<Turn> loadByDate(LocalDate localDate, Long doctorId) {
        logger.debug("execute jpql for load turns by date with doctors id");
        return em.createQuery("select t from Turn t where DATE(t.time) = :date and t.doctor.id = :id and t.isCancel = false", Turn.class)
                .setParameter("date", localDate).setParameter("id", doctorId).getResultList();
    }

    @Override
    public void deleteCanceled() {
        logger.debug("execute jpql for delete canceled turns");
        em.createQuery("delete from Turn t where t.isCancel = true").executeUpdate();
    }

    @Override
    public List<Turn> loadTurnByPatient(Long patientId) {
        logger.debug("execute jpql for return patient returns");
        return em.createQuery("select t from Turn t where t.patient.id = :id and t.isCancel = false and t.time > current_date()", Turn.class)
                .setParameter("id", patientId).getResultList();
    }
}
