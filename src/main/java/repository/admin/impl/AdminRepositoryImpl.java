package repository.admin.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.admin.Admin;
import jakarta.persistence.EntityManager;
import repository.admin.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin> implements AdminRepository {
    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

}
