package ir.maktab.file.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentCourse> courses = new ArrayList<>();
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentCourseRating> studentCourseRatings = new ArrayList<>();

}
