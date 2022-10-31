package base.repository;

import base.entity.BaseEntity;

import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {

    void saveOrUpdate(E entity);
    Optional<E> loadById(Long id);
    void delete(E entity);

}
