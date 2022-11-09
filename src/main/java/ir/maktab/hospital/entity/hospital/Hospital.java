package ir.maktab.hospital.entity.hospital;

import ir.maktab.hospital.base.entity.BaseEntity;
import ir.maktab.hospital.entity.admin.Admin;
import ir.maktab.hospital.entity.clinic.Clinic;
import jakarta.persistence.Entity;
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
