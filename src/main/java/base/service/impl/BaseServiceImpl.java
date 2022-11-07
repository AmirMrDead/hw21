package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;
import jakarta.persistence.EntityManager;
import util.Hibernate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl <E extends BaseEntity,R extends BaseRepository<E>>
        implements BaseService<E> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void saveOrUpdate(E entity) {
        repository.getEntityManager().getTransaction().begin();
        repository.saveOrUpdate(entity);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public Optional<E> loadById(Long id) {
        try {
            return repository.loadById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(E entity) {
        repository.getEntityManager().getTransaction().begin();
        repository.delete(entity);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public List<E> loadAll() {
        try {
            return repository.loadAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
