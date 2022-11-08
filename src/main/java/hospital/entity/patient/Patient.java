package hospital.entity.patient;

import hospital.entity.Person;
import hospital.entity.prescription.Prescription;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions = new ArrayList<>();

    public Patient(String firstname, String lastname, String nationalCode, String password) {
        super(firstname, lastname, nationalCode, password);
    }

    @Override
    public String toString() {
        return "Patient{ firstname= " + this.getFirstname() +
                " - lastname= " + this.getLastname() +
                " - national code= " + this.getNationalCode() +
                "}";
    }
}
