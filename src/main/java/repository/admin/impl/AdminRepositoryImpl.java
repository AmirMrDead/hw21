package repository.admin.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.admin.Admin;
import repository.admin.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin> implements AdminRepository {
    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
