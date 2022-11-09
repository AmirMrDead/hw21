package ir.maktab.hospital.service.drug.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.drug.Drug;
import ir.maktab.hospital.service.drug.DrugService;
import ir.maktab.hospital.repository.drug.DrugRepository;

public class DrugServiceImpl extends BaseServiceImpl<Drug, DrugRepository> implements DrugService {

    public DrugServiceImpl(DrugRepository repository) {
        super(repository);
    }
}
