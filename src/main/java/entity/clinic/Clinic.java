package entity.clinic;

import base.entity.BaseEntity;
import entity.doctor.Doctor;
import entity.hospital.Hospital;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Clinic extends BaseEntity {

    private String name;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors = new ArrayList<>();


}
