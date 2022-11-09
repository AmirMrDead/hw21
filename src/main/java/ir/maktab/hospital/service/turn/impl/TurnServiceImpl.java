package ir.maktab.hospital.service.turn.impl;

import ir.maktab.hospital.base.service.impl.BaseServiceImpl;
import ir.maktab.hospital.entity.turn.Turn;
import ir.maktab.hospital.repository.turn.TurnRepository;
import ir.maktab.hospital.service.turn.TurnService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class TurnServiceImpl extends BaseServiceImpl<Turn, TurnRepository> implements TurnService {

    private static final Logger logger = LogManager.getLogger(TurnServiceImpl.class);
    public TurnServiceImpl(TurnRepository repository) {
        super(repository);
    }

    @Override
    public List<Turn> loadByDate(LocalDate localDate, Long doctorId) {
        logger.info("load turns by date for doctor");
        return repository.loadByDate(localDate, doctorId);
    }

    @Override
    public void deleteCanceled() {
        logger.info("delete turns were canceled");
        repository.getEntityManager().getTransaction().begin();
        repository.deleteCanceled();
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public List<Turn> loadTurnByPatient(Long patientId) {
        logger.info("load turns with patient");
        return repository.loadTurnByPatient(patientId);
    }
}
