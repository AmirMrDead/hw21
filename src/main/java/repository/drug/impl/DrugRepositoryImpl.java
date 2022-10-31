package repository.drug.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.drug.Drug;
import repository.drug.DrugRepository;

public class DrugRepositoryImpl extends BaseRepositoryImpl<Drug> implements DrugRepository {
    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
}
