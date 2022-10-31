package service.turn.impl;

import base.repository.BaseRepository;
import base.service.impl.BaseServiceImpl;
import entity.turn.Turn;
import repository.turn.impl.TurnRepositoryImpl;
import service.turn.TurnService;

public class TurnServiceImpl extends BaseServiceImpl<Turn> implements TurnService {
    @Override
    protected BaseRepository<Turn> getBaseRepository() {
        return new TurnRepositoryImpl();
    }
}
