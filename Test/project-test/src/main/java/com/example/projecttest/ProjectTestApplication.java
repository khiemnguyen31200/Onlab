package com.example.projecttest;

import com.example.projecttest.model.entitystudent.Course;
import com.example.projecttest.model.entitystudent.CourseStudent;
import com.example.projecttest.model.entitystudent.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.security.auth.Subject;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ProjectTestApplication implements CommandLineRunner {

    private EntityManager entityManager;
    public static void main(String[] args) {
        SpringApplication.run(ProjectTestApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var subject1 = Course.builder().id(1).name("math").build();
        var subject2 = Course.builder().id(2).name("music").build();
        var subject3 = Course.builder().id(3).name("history").build();

    var student1 = Student.builder().id(1).name("bob").build();
    var student2 = Student.builder().id(2).name("alice").build();
    var student3 = Student.builder().id(3).name("tom").build();
    var student4 = Student.builder().id(4).name("jane").build();
    var student5 = Student.builder().id(5).name("van").build();
    var student6 = Student.builder().id(6).name("long").build();


    student1.setStudentSubjects(List.of(new CourseStudent(student1,subject1,7),new CourseStudent(student1,subject2,5),new CourseStudent(student1,subject3,8)));
    student2.setStudentSubjects(List.of(new CourseStudent(student2,subject1,8),new CourseStudent(student2,subject2,2),new CourseStudent(student2,subject3,9)));
    student3.setStudentSubjects(List.of(new CourseStudent(student3,subject1,4),new CourseStudent(student3,subject3,10)));
    student4.setStudentSubjects(List.of(new CourseStudent(student4,subject2,9),new CourseStudent(student4,subject3,8)));
    student5.setStudentSubjects(List.of(new CourseStudent(student5,subject1,9),new CourseStudent(student5,subject2,7),new CourseStudent(student5,subject3,6)));
    student6.setStudentSubjects(List.of(new CourseStudent(student6,subject1,10),new CourseStudent(student6,subject2,3)));



    entityManager.persist(student1);
    entityManager.persist(student2);
    entityManager.persist(student3);
    entityManager.persist(student4);
    entityManager.persist(student5);
    entityManager.persist(student6);
    entityManager.persist(subject1);
    entityManager.persist(subject2);
    entityManager.persist(subject3);

    entityManager.flush();


    }
}
