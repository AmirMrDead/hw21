package hospital.service.turn.impl;

import hospital.base.service.impl.BaseServiceImpl;
import hospital.entity.turn.Turn;
import hospital.repository.turn.TurnRepository;
import hospital.service.turn.TurnService;

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

    @Override
    public void deleteCanceled() {
        repository.getEntityManager().getTransaction().begin();
        repository.deleteCanceled();
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public List<Turn> loadTurnByPatient(Long patientId) {
        return repository.loadTurnByPatient(patientId);
    }
}
