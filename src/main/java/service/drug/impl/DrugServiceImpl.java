package service.drug.impl;

import base.service.impl.BaseServiceImpl;
import entity.drug.Drug;
import repository.drug.DrugRepository;
import service.drug.DrugService;

public class DrugServiceImpl extends BaseServiceImpl<Drug, DrugRepository> implements DrugService {

    public DrugServiceImpl(DrugRepository repository) {
        super(repository);
    }
}
