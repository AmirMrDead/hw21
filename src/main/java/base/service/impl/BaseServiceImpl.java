package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;

import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity> implements BaseService<E> {

    protected abstract BaseRepository<E> getBaseRepository();

    @Override
    public void saveOrUpdate(E entity) {
        getBaseRepository().saveOrUpdate(entity);
    }

    @Override
    public Optional<E> loadById(Long id) {
        return getBaseRepository().loadById(id);
    }

    @Override
    public void delete(E entity) {
        getBaseRepository().delete(entity);
    }
}
