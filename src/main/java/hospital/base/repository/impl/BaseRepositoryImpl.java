package hospital.base.repository.impl;

import hospital.base.entity.BaseEntity;
import hospital.base.repository.BaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {

    public abstract Class<E> getEntityClass();

    protected final EntityManager em;

    protected BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveOrUpdate(E entity) {
        if (Boolean.TRUE.equals(entity.isNow())) {
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

    @Override
    public List<E> loadAll() {
        String jpql = "from " + getEntityClass().getSimpleName();
        return em.createQuery(jpql, getEntityClass()).getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
