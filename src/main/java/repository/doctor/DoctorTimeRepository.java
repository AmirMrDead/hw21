package repository.doctor;

import base.repository.BaseRepository;
import entity.doctor.DoctorTime;

import java.util.List;

public interface DoctorTimeRepository extends BaseRepository<DoctorTime> {

    List<DoctorTime> loadByDoctorId(Long id);

}
