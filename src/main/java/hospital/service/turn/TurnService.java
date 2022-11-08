package hospital.service.turn;

import hospital.base.service.BaseService;
import hospital.entity.turn.Turn;

import java.time.LocalDate;
import java.util.List;

public interface TurnService extends BaseService<Turn> {

    List<Turn> loadByDate(LocalDate localDate, Long doctorId);
    void deleteCanceled();
    List<Turn> loadTurnByPatient(Long patientId);

}
