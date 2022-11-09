package ir.maktab.hospital.repository.turn;

import ir.maktab.hospital.base.repository.BaseRepository;
import ir.maktab.hospital.entity.turn.Turn;

import java.time.LocalDate;
import java.util.List;

public interface TurnRepository extends BaseRepository<Turn> {

    List<Turn> loadByDate(LocalDate localDate,Long doctorId);
    void deleteCanceled();

    List<Turn> loadTurnByPatient(Long patientId);

}
