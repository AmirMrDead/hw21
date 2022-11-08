package hospital.util;

import hospital.entity.patient.Patient;
import hospital.entity.turn.Turn;
import hospital.repository.patient.impl.PatientRepositoryImpl;
import hospital.repository.turn.impl.TurnRepositoryImpl;
import hospital.service.patient.PatientService;
import hospital.service.patient.impl.PatientServiceImpl;
import hospital.service.turn.TurnService;
import hospital.service.turn.impl.TurnServiceImpl;

import java.util.List;

public class AdminOperations {

    public void showPatientInformation(){
        PatientService patientService = new PatientServiceImpl(new PatientRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        List<Patient> patients = patientService.loadAll();
        patients.forEach(System.out::println);
    }

    public void showTurns(){
        TurnService turnService = new TurnServiceImpl(new TurnRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        List<Turn> turns = turnService.loadAll();
        turns.forEach(System.out::println);
    }

    public void deleteCanceledTurns(){
        TurnService turnService = new TurnServiceImpl(new TurnRepositoryImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        turnService.deleteCanceled();
    }

}
