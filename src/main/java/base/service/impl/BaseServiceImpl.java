package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;
import jakarta.persistence.EntityManager;
import util.Hibernate;

import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity> implements BaseService<E> {

    protected abstract BaseRepository<E> getBaseRepository();
    protected final EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();

    @Override
    public void saveOrUpdate(E entity) {
        em.getTransaction().begin();
        getBaseRepository().saveOrUpdate(entity);
        em.getTransaction().commit();
    }

    @Override
    public Optional<E> loadById(Long id) {
        try {
            return getBaseRepository().loadById(id);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public void delete(E entity) {
        em.getTransaction().begin();
        getBaseRepository().delete(entity);
        em.getTransaction().commit();
    }
}
