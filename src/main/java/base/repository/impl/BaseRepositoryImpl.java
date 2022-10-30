package base.repository.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import util.Hibernate;

import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {

    public abstract Class<E> getEntityClass();

    protected final EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();

    @Override
    public void saveOrUpdate(E entity) {
        if (entity.isNow()) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
    }

    @Override
    public Optional<E> loadById(Long id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public void delete(E entity) {
        em.remove(entity);
    }
}
