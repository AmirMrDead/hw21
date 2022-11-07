package repository.turn;

import base.repository.BaseRepository;
import entity.turn.Turn;

import java.time.LocalDate;
import java.util.List;

public interface TurnRepository extends BaseRepository<Turn> {

    List<Turn> loadByDate(LocalDate localDate,Long doctorId);

}
