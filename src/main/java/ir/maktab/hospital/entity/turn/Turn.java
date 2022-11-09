package ir.maktab.hospital.entity.turn;

import ir.maktab.hospital.base.entity.BaseEntity;
import ir.maktab.hospital.entity.doctor.Doctor;
import ir.maktab.hospital.entity.patient.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Turn extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime time;
    private Boolean isCancel;

}
