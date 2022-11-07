package service.turn.impl;

import base.service.impl.BaseServiceImpl;
import entity.turn.Turn;
import repository.turn.TurnRepository;
import service.turn.TurnService;

import java.time.LocalDate;
import java.util.List;

public class TurnServiceImpl extends BaseServiceImpl<Turn,TurnRepository> implements TurnService {


    public TurnServiceImpl(TurnRepository repository) {
        super(repository);
    }

    @Override
    public List<Turn> loadByDate(LocalDate localDate, Long doctorId) {
        return repository.loadByDate(localDate, doctorId);
    }
}
