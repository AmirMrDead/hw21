package hospital.service.admin.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.admin.Admin;
import hospital.repository.admin.AdminRepository;
import hospital.service.admin.AdminService;

import java.util.Optional;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService  {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
    @Override
    public Optional<Admin> login(String nationalCode, String password) {
        try {
            return repository.login(nationalCode, password);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
