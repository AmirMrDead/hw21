package hospital.repository.doctor;

import hospital.base.repository.BaseRepository;
import hospital.entity.doctor.DoctorTime;

import java.util.List;

public interface DoctorTimeRepository extends BaseRepository<DoctorTime> {

    List<DoctorTime> loadByDoctorId(Long id);

}
