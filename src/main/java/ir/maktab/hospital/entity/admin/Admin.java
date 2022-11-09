package ir.maktab.hospital.entity.admin;

import ir.maktab.hospital.entity.Person;
import ir.maktab.hospital.entity.hospital.Hospital;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Admin extends Person {

    @OneToOne
    private Hospital hospital;

}
