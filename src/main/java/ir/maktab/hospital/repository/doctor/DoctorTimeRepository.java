package ir.maktab.hospital.repository.doctor;

import ir.maktab.hospital.base.repository.BaseRepository;
import ir.maktab.hospital.entity.doctor.DoctorTime;

import java.util.List;

public interface DoctorTimeRepository extends BaseRepository<DoctorTime> {

    List<DoctorTime> loadByDoctorId(Long id);

}
