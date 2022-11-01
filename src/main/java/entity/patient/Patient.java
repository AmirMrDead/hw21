package entity.patient;

import entity.Person;
import entity.prescription.Prescription;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient extends Person {

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Prescription> prescriptions = new ArrayList<>();

    public Patient(String firstname, String lastname, String nationalCode, String password) {
        super(firstname, lastname, nationalCode, password);
    }
}
