package service.drug.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.drug.Drug;
import repository.drug.impl.DrugRepositoryImpl;
import service.drug.DrugService;

public class DrugServiceImpl extends BaseServiceImpl<Drug> implements DrugService {
    @Override
    protected BaseRepository<Drug> getBaseRepository() {
        return new DrugRepositoryImpl();
    }
}
