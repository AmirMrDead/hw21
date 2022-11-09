package ir.maktab.hospital.service.doctor;

import ir.maktab.hospital.base.service.BaseService;
import ir.maktab.hospital.entity.doctor.DoctorTime;

import java.util.List;

public interface DoctorTimeService extends BaseService<DoctorTime> {

    List<DoctorTime> loadByDoctorId(Long id);

}
