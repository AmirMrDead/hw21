package service.admin.impl;

import base.service.impl.BaseServiceImpl;
import entity.admin.Admin;
import repository.admin.AdminRepository;
import service.admin.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService  {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
}
