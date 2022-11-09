package ir.maktab.hospital.util;

import ir.maktab.hospital.entity.patient.Patient;
import ir.maktab.hospital.entity.turn.Turn;
import ir.maktab.hospital.repository.patient.impl.PatientRepositoryImpl;
import ir.maktab.hospital.service.patient.PatientService;
import ir.maktab.hospital.service.patient.impl.PatientServiceImpl;
import ir.maktab.hospital.repository.turn.impl.TurnRepositoryImpl;
import ir.maktab.hospital.service.turn.TurnService;
import ir.maktab.hospital.service.turn.impl.TurnServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AdminOperations {

    private static final Logger logger = LogManager.getLogger(AdminOperations.class);

    public void showPatientInformation(){
        logger.debug("show patient information");
        PatientService patientService = new PatientServiceImpl(new PatientRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        List<Patient> patients = patientService.loadAll();
        patients.forEach(System.out::println);
    }

    public void showTurns(){
        logger.debug("show patient turns");
        TurnService turnService = new TurnServiceImpl(new TurnRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        List<Turn> turns = turnService.loadAll();
        turns.forEach(System.out::println);
    }

    public void deleteCanceledTurns(){
        logger.debug("delete canceled turns");
        TurnService turnService = new TurnServiceImpl(new TurnRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        turnService.deleteCanceled();
    }

}
