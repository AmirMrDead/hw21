package repository.doctor.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.doctor.DoctorTime;
import jakarta.persistence.EntityManager;
import repository.doctor.DoctorTimeRepository;

import java.util.List;

public class DoctorTimeRepositoryImpl extends BaseRepositoryImpl<DoctorTime> implements DoctorTimeRepository {
    public DoctorTimeRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<DoctorTime> getEntityClass() {
        return DoctorTime.class;
    }

    @Override
    public List<DoctorTime> loadByDoctorId(Long id) {
        return em.createQuery("select d from DoctorTime  d where d.doctor.id = :id", DoctorTime.class)
                .setParameter("id", id).getResultList();
    }
}
