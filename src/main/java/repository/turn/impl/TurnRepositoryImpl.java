package repository.turn.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.turn.Turn;
import repository.turn.TurnRepository;

public class TurnRepositoryImpl extends BaseRepositoryImpl<Turn> implements TurnRepository {
    @Override
    public Class<Turn> getEntityClass() {
        return Turn.class;
    }
}
