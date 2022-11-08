package hospital.repository.drug.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.drug.Drug;
import jakarta.persistence.EntityManager;
import hospital.repository.drug.DrugRepository;

public class DrugRepositoryImpl extends BaseRepositoryImpl<Drug> implements DrugRepository {
    public DrugRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
}
