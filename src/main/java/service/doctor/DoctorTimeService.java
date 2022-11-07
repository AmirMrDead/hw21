package service.doctor;

import base.service.BaseService;
import entity.doctor.DoctorTime;

import java.util.List;

public interface DoctorTimeService extends BaseService<DoctorTime> {

    List<DoctorTime> loadByDoctorId(Long id);

}
