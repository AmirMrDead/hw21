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
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<StudentCourse> students = new ArrayList<>();
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentCourseRating> studentCourseRatings = new ArrayList<>();

}
