package ir.maktab.file.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
public class StudentCourseRating implements Serializable {

    @EmbeddedId
    private StudentCourseId studentCourseId;
    private Timestamp timestamp;
    private Double rate;
    private String comment;
    @ManyToOne
    @MapsId("studentId")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    private Course course;

}
