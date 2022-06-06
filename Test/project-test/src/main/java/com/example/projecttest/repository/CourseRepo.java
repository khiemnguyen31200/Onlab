package com.example.projecttest.repository;

import com.example.projecttest.model.entitystudent.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
