package hospital.service.doctor;

import hospital.base.service.BaseService;
import hospital.entity.doctor.DoctorTime;

import java.util.List;

public interface DoctorTimeService extends BaseService<DoctorTime> {

    List<DoctorTime> loadByDoctorId(Long id);

}
