package ir.maktab.hospital.service.doctor.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.doctor.DoctorTime;
import ir.maktab.hospital.repository.doctor.DoctorTimeRepository;
import ir.maktab.hospital.service.doctor.DoctorTimeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DoctorTimeServiceImpl extends BaseServiceImpl<DoctorTime, DoctorTimeRepository> implements DoctorTimeService {

    private static final Logger logger = LogManager.getLogger(DoctorTimeServiceImpl.class);

    public DoctorTimeServiceImpl(DoctorTimeRepository repository) {
        super(repository);
    }

    @Override
    public List<DoctorTime> loadByDoctorId(Long id) {
        logger.debug("return doctor times for doctors");
        return repository.loadByDoctorId(id);
    }
}
