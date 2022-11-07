package repository.drug.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.drug.Drug;
import jakarta.persistence.EntityManager;
import repository.drug.DrugRepository;

public class DrugRepositoryImpl extends BaseRepositoryImpl<Drug> implements DrugRepository {
    public DrugRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
}
