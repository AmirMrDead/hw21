package hospital.entity.admin;

import hospital.entity.Person;
import hospital.entity.hospital.Hospital;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Admin extends Person {

    @OneToOne
    private Hospital hospital;

}
