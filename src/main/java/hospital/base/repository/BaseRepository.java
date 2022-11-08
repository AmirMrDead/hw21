package hospital.base.repository;

import hospital.base.entity.BaseEntity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {

    void saveOrUpdate(E entity);
    Optional<E> loadById(Long id);
    void delete(E entity);
    List<E> loadAll();
    EntityManager getEntityManager();

}
