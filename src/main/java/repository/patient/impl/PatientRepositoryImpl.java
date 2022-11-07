package repository.patient.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.patient.Patient;
import jakarta.persistence.EntityManager;
import repository.patient.PatientRepository;

import java.util.Optional;

public class PatientRepositoryImpl extends BaseRepositoryImpl<Patient> implements PatientRepository {
    public PatientRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Optional<Patient> findByNationalCode(String nationalCode) {
        String jpql = """
                select p from Patient p where p.nationalCode = :nationalCode
                """;
        return Optional.ofNullable(em.createQuery(jpql, Patient.class).setParameter("nationalCode", nationalCode).getSingleResult());
    }

    @Override
    public Optional<Patient> login(String nationalCode, String password) {
        String jpql = """
                select p from Patient p where p.nationalCode = :nationalCode and p.password = :password
                """;
        return Optional.ofNullable(em.createQuery(jpql, Patient.class)
                .setParameter("nationalCode", nationalCode).setParameter("password",password).getSingleResult());
    }
}
