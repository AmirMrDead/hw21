package ir.maktab.hospital.repository.patient;

import ir.maktab.hospital.base.repository.BaseRepository;
import ir.maktab.hospital.entity.patient.Patient;

import java.util.Optional;

public interface PatientRepository extends BaseRepository<Patient> {

    Optional<Patient> findByNationalCode(String nationalCode);
    Optional<Patient> login(String nationalCode, String password);

}
