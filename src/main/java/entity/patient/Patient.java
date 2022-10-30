package entity.patient;

import entity.Person;
import entity.prescription.Prescription;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Patient extends Person {

    @OneToOne
    private Prescription prescription;

}
