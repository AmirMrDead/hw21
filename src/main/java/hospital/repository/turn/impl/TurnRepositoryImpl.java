package hospital.repository.turn.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.turn.Turn;
import jakarta.persistence.EntityManager;
import hospital.repository.turn.TurnRepository;

import java.time.LocalDate;
import java.util.List;

public class TurnRepositoryImpl extends BaseRepositoryImpl<Turn> implements TurnRepository {
    public TurnRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Turn> getEntityClass() {
        return Turn.class;
    }

    @Override
    public List<Turn> loadByDate(LocalDate localDate, Long doctorId) {
        return em.createQuery("select t from Turn t where DATE(t.time) = :date and t.doctor.id = :id and t.isCancel = false", Turn.class)
                .setParameter("date", localDate).setParameter("id", doctorId).getResultList();
    }

    @Override
    public void deleteCanceled() {
        em.createQuery("delete from Turn t where t.isCancel = true").executeUpdate();
    }

    @Override
    public List<Turn> loadTurnByPatient(Long patientId) {
        return em.createQuery("select t from Turn t where t.patient.id = :id and t.isCancel = false and t.time > current_date()", Turn.class)
                .setParameter("id", patientId).getResultList();
    }
}
