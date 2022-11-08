package hospital.service.drug.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.drug.Drug;
import hospital.repository.drug.DrugRepository;
import hospital.service.drug.DrugService;

public class DrugServiceImpl extends BaseServiceImpl<Drug, DrugRepository> implements DrugService {

    public DrugServiceImpl(DrugRepository repository) {
        super(repository);
    }
}
