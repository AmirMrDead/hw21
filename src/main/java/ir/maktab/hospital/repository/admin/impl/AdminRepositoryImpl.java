package ir.maktab.hospital.repository.admin.impl;

import ir.maktab.hospital.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.hospital.entity.admin.Admin;
import jakarta.persistence.EntityManager;
import ir.maktab.hospital.repository.admin.AdminRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin> implements AdminRepository {

    private static final Logger logger = LogManager.getLogger(AdminRepositoryImpl.class);
    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public Optional<Admin> login(String nationalCode, String password) {
        logger.info("login admin jpql");
        String jpql = """
                select a from Admin a where a.nationalCode = :nationalCode and a.password = :password
                """;
        logger.debug("tru to execute query");
        return Optional.ofNullable(em.createQuery(jpql, Admin.class)
                .setParameter("nationalCode", nationalCode).setParameter("password",password).getSingleResult());
    }
}
