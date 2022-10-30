package entity.doctor;

import entity.Person;
import entity.clinic.Clinic;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor extends Person {

    @ManyToOne
    private Clinic clinic;
    @Enumerated(EnumType.STRING)
    private DoctorPosition position;
    @Enumerated(EnumType.STRING)
    private DoctorStatus status;
    @OneToMany(mappedBy = "doctor")
    private List<DoctorTime> times = new ArrayList<>();

}
