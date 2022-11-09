package ir.maktab.hospital.repository.doctor.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.doctor.DoctorTime;
import ir.maktab.hospital.repository.doctor.DoctorTimeRepository;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DoctorTimeRepositoryImpl extends BaseRepositoryImpl<DoctorTime> implements DoctorTimeRepository {

    private static final Logger logger = LogManager.getLogger(DoctorTimeRepositoryImpl.class);
    public DoctorTimeRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<DoctorTime> getEntityClass() {
        return DoctorTime.class;
    }

    @Override
    public List<DoctorTime> loadByDoctorId(Long id) {
        logger.debug("execute jpql for load doctor times for doctors");
        return em.createQuery("select d from DoctorTime  d where d.doctor.id = :id", DoctorTime.class)
                .setParameter("id", id).getResultList();
    }
}
