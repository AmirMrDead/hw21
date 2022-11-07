package repository.turn.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.turn.Turn;
import jakarta.persistence.EntityManager;
import repository.turn.TurnRepository;

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
}
