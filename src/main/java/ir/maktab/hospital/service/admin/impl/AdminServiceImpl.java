package ir.maktab.hospital.service.admin.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.admin.Admin;
import ir.maktab.hospital.repository.admin.AdminRepository;
import ir.maktab.hospital.service.admin.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService {

    private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
    @Override
    public Optional<Admin> login(String nationalCode, String password) {
        logger.info("login admin");
        try {
            logger.debug("try to login for admin");
            return repository.login(nationalCode, password);
        } catch (Exception e) {
            logger.error("can't login admin");
            return Optional.empty();
        }
    }
}
