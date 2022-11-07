package entity.doctor;

import entity.Person;
import entity.clinic.Clinic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Doctor extends Person {

    @ManyToOne
    private Clinic clinic;
    @Enumerated(EnumType.STRING)
    private DoctorPosition position;
    @Enumerated(EnumType.STRING)
    private DoctorStatus status;
    @OneToMany(mappedBy = "doctor")
    private List<DoctorTime> times = new ArrayList<>();

    @Override
    public String toString() {
        return "Doctor{" +
                " id= " + this.getId() +
                ", firstname= " + this.getFirstname() +
                ", lastname= " + this.getLastname() +
                ", position= " + position +
                ", status= " + status +
                '}';
    }

}
