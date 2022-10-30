package entity.hospital;

import base.entity.BaseEntity;
import entity.admin.Admin;
import entity.clinic.Clinic;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital extends BaseEntity {

    @OneToMany(mappedBy = "hospital")
    private List<Clinic> clinics = new ArrayList<>();
    @OneToOne
    private Admin admin;

}
