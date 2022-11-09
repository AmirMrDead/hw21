package ir.maktab.hospital.service.patient;

import ir.maktab.hospital.base.service.BaseService;
import ir.maktab.hospital.entity.patient.Patient;

import java.util.Optional;

public interface PatientService extends BaseService<Patient> {

    Optional<Patient> findByNationalCode(String nationalCode);
    Optional<Patient> login(String nationalCode, String password);

}
