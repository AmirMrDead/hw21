package ir.maktab.hospital.repository.patient.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.patient.Patient;
import ir.maktab.hospital.repository.patient.PatientRepository;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class PatientRepositoryImpl extends BaseRepositoryImpl<Patient> implements PatientRepository {

    private static final Logger logger = LogManager.getLogger(PatientRepositoryImpl.class);
    public PatientRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Optional<Patient> findByNationalCode(String nationalCode) {
        logger.debug("execute jpql for find patient with national code");
        String jpql = """
                select p from Patient p where p.nationalCode = :nationalCode
                """;
        return Optional.ofNullable(em.createQuery(jpql, Patient.class).setParameter("nationalCode", nationalCode).getSingleResult());
    }

    @Override
    public Optional<Patient> login(String nationalCode, String password) {
        logger.debug("execute jpql for login patient");
        String jpql = """
                select p from Patient p where p.nationalCode = :nationalCode and p.password = :password
                """;
        return Optional.ofNullable(em.createQuery(jpql, Patient.class)
                .setParameter("nationalCode", nationalCode).setParameter("password",password).getSingleResult());
    }
}
