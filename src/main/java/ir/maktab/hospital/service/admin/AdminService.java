package ir.maktab.hospital.service.admin;

import ir.maktab.hospital.base.service.BaseService;
import ir.maktab.hospital.entity.admin.Admin;

import java.util.Optional;

public interface AdminService extends BaseService<Admin> {

    Optional<Admin> login(String nationalCode, String password);

}
