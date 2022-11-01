package service.patient;

import base.service.BaseService;
import entity.patient.Patient;

import java.util.Optional;

public interface PatientService extends BaseService<Patient> {

    Optional<Patient> findByNationalCode(String nationalCode);
    Optional<Patient> login(String nationalCode, String password);

}
