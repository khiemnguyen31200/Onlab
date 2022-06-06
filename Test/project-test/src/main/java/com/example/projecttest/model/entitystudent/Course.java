package com.example.projecttest.model.entitystudent;

import com.example.projecttest.model.entityproduct.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name="course")
@Table(name="course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    private long id;
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<CourseStudent> studentSubjects = new ArrayList<>();


}
