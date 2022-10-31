package service.admin.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.admin.Admin;
import repository.admin.impl.AdminRepositoryImpl;
import service.admin.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    @Override
    protected BaseRepository<Admin> getBaseRepository() {
        return new AdminRepositoryImpl();
    }
}
