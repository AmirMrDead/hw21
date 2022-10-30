package base.repository;

import base.entity.BaseEntity;

public interface BaseRepository<E extends BaseEntity> {

    void saveOrUpdate(E e);
    void loadById(Long id);
    void delete(E e);

}
