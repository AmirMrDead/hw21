package ir.maktab.hospital.base.service;

import ir.maktab.hospital.base.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity> {

    void saveOrUpdate(E entity);
    Optional<E> loadById(Long id);
    void delete(E entity);
    List<E> loadAll();

}
