package entity.hospital;

import base.entity.BaseEntity;
import entity.admin.Admin;
import entity.clinic.Clinic;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hospital extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "hospital")
    private List<Clinic> clinics = new ArrayList<>();
    @OneToOne(mappedBy = "hospital")
    private Admin admin;

}
