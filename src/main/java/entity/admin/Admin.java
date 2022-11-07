package entity.admin;

import entity.Person;
import entity.hospital.Hospital;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Admin extends Person {

    @OneToOne
    private Hospital hospital;

}
