package com.example.projecttest.model.entitystudent;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "student_subject")
@Table(name = "student_subject")
@Data
@NoArgsConstructor

public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @Size(min = 8,max = 20)
    private float score;

    public CourseStudent(Student student, Course course, float score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }
}
