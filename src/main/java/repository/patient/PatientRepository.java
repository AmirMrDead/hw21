package repository.patient;

import base.repository.BaseRepository;
import entity.patient.Patient;

import java.util.Optional;

public interface PatientRepository extends BaseRepository<Patient> {

    Optional<Patient> findByNationalCode(String nationalCode);
    Optional<Patient> login(String nationalCode, String password);

}
