package entity.doctor;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class DoctorTime extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Days day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer duringTime;
    @ManyToOne
    private Doctor doctor;

}
