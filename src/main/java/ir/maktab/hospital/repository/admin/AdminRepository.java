package ir.maktab.hospital.repository.admin;

import ir.maktab.hospital.base.repository.BaseRepository;
import ir.maktab.hospital.entity.admin.Admin;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin> {

    Optional<Admin> login(String nationalCode, String password);

}
