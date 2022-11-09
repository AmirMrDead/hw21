package ir.maktab.hospital.base.repository.impl;

import ir.maktab.hospital.base.entity.BaseEntity;
import ir.maktab.hospital.base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {

    public abstract Class<E> getEntityClass();
    private static final Logger logger = LogManager.getLogger(BaseRepositoryImpl.class);
    protected final EntityManager em;

    protected BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveOrUpdate(E entity) {
        if (Boolean.TRUE.equals(entity.isNow())) {
            logger.debug("save {}" , getEntityClass().getSimpleName());
            em.persist(entity);
        } else {
            logger.debug("update {}" , getEntityClass().getSimpleName());
            em.merge(entity);
        }
    }

    @Override
    public Optional<E> loadById(Long id) {
        logger.debug("load by id for {}" , getEntityClass().getSimpleName());
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public void delete(E entity) {
        logger.debug("delete {}" , getEntityClass().getSimpleName());
        em.remove(entity);
    }

    @Override
    public List<E> loadAll() {
        logger.debug("load all {}" , getEntityClass().getSimpleName());
        String jpql = "from " + getEntityClass().getSimpleName();
        return em.createQuery(jpql, getEntityClass()).getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
