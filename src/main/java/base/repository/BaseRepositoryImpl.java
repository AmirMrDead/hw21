package base.repository;

import base.entity.BaseEntity;

public class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E>{

    @Override
    public void saveOrUpdate(E e) {

    }

    @Override
    public void loadById(Long id) {

    }

    @Override
    public void delete(E e) {

    }
}
