package hospital.repository.admin.impl;

import hospital.base.repository.impl.BaseRepositoryImpl;
import hospital.entity.admin.Admin;
import jakarta.persistence.EntityManager;
import hospital.repository.admin.AdminRepository;

import java.util.Optional;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin> implements AdminRepository {
    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public Optional<Admin> login(String nationalCode, String password) {
        String jpql = """
                select a from Admin a where a.nationalCode = :nationalCode and a.password = :password
                """;
        return Optional.ofNullable(em.createQuery(jpql, Admin.class)
                .setParameter("nationalCode", nationalCode).setParameter("password",password).getSingleResult());
    }
}
