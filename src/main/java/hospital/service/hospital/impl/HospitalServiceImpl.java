package hospital.service.hospital.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.hospital.Hospital;
import hospital.repository.hospital.HospitalRepository;
import hospital.service.hospital.HospitalService;

public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalRepository> implements HospitalService {

    public HospitalServiceImpl(HospitalRepository repository) {
        super(repository);
    }
}
