package hospital.service.admin;

import hospital.base.service.BaseService;
import hospital.entity.admin.Admin;

import java.util.Optional;

public interface AdminService extends BaseService<Admin> {

    Optional<Admin> login(String nationalCode, String password);

}
