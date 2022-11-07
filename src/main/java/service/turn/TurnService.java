package service.turn;

import base.service.BaseService;
import entity.turn.Turn;

import java.time.LocalDate;
import java.util.List;

public interface TurnService extends BaseService<Turn> {

    List<Turn> loadByDate(LocalDate localDate, Long doctorId);

}
