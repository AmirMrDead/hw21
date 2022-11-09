package ir.maktab.hospital.repository.drug.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.drug.Drug;
import ir.maktab.hospital.repository.drug.DrugRepository;
import jakarta.persistence.EntityManager;

public class DrugRepositoryImpl extends BaseRepositoryImpl<Drug> implements DrugRepository {
    public DrugRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
}
