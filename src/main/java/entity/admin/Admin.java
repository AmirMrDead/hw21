package entity.admin;

import entity.Person;
import entity.hospital.Hospital;
import entity.patient.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends Person {

    @OneToOne
    private Hospital hospital;
    /*@OneToMany
    private List<Patient> patients = new ArrayList<>();*/

}
