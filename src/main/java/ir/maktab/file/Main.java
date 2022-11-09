package ir.maktab.file;

import ir.maktab.file.entity.*;
import ir.maktab.file.util.Hibernate;
import jakarta.persistence.EntityManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) throws IOException {

        EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();

        FileReader fileReader = new FileReader("information.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String[] objects = bufferedReader.readLine().split(",");

            Course course = saveCourse(em, objects);

            Student student = saveStudent(em, objects);

            saveStudentCourse(em, course, student);

            saveStudentCourseRating(em, objects, course, student);

        }
    }

    private static void saveStudentCourseRating(EntityManager em, String[] objects, Course course, Student student) {
        StudentCourseRating studentCourseRating = new StudentCourseRating();
        studentCourseRating.setStudentCourseId(new StudentCourseId(student.getId(), course.getId()));
        studentCourseRating.setCourse(course);
        studentCourseRating.setStudent(student);
        studentCourseRating.setTimestamp(Timestamp.valueOf(objects[2]));
        studentCourseRating.setRate(Double.parseDouble(objects[3]));
        studentCourseRating.setComment(objects[4].replaceAll("\"", ""));
        try {
            em.getTransaction().begin();
            em.persist(studentCourseRating);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void saveStudentCourse(EntityManager em, Course course, Student student) {
        StudentCourse studentCourse;
        boolean checkNewStudentCourse;
        try {
            studentCourse = em.createQuery("select sc from StudentCourse " +
                    "sc where sc.course.id = :courseId and sc.student.id = :studentId", StudentCourse.class)
                    .setParameter("courseId", course.getId())
                    .setParameter("studentId", student.getId()).getSingleResult();
            checkNewStudentCourse = false;
        }catch (Exception e){
            studentCourse = new StudentCourse();
            studentCourse.setStudentCourseId(new StudentCourseId(student.getId(), course.getId()));
            studentCourse.setCourse(course);
            studentCourse.setStudent(student);
            checkNewStudentCourse = true;
        }
        if(checkNewStudentCourse){
            em.getTransaction().begin();
            em.persist(studentCourse);
            em.getTransaction().commit();
        }
    }

    private static Student saveStudent(EntityManager em, String[] objects) {
        Student student;
        String firstname;
        String lastname;
        boolean checkNewStudent;
        String[] names = objects[1].split(" ");
        if (names.length == 2) {
            firstname = names[0];
            lastname = names[1];
        } else {
            firstname = names[0];
            lastname = "";
        }
        try {
            student = em.createQuery("select s from Student s where s.firstname" +
                            " = :firstname and s.lastname = :lastname", Student.class)
                    .setParameter("firstname",firstname)
                    .setParameter("lastname",lastname ).getSingleResult();
            checkNewStudent = false;
        } catch (Exception e) {
            student = new Student();
            student.setFirstname(firstname);
            student.setLastname(lastname);
            checkNewStudent = true;
        }
        if (checkNewStudent) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
        return student;
    }

    private static Course saveCourse(EntityManager em, String[] objects) {
        boolean checkNewCourse;
        Course course;
        try {
            course = em.createQuery("select c from Course c where c.name = :name", Course.class)
                    .setParameter("name", objects[0].replaceAll("\"", "")).getSingleResult();
            checkNewCourse = false;
        } catch (Exception e) {
            course = new Course();
            course.setName(objects[0].replaceAll("\"", ""));
            checkNewCourse = true;
        }
        if (checkNewCourse) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
        return course;
    }

}
