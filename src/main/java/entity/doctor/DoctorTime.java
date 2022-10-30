package entity.doctor;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;

@Entity
public class DoctorTime extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Days day;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    private Doctor doctor;

}
