package hospital.repository.admin;

import hospital.base.repository.BaseRepository;
import hospital.entity.admin.Admin;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin> {

    Optional<Admin> login(String nationalCode, String password);

}
