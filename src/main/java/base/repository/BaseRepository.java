package base.repository;

import base.entity.BaseEntity;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {

    void saveOrUpdate(E e);
    Optional<E> loadById(Long id);
    void delete(E e);

}
