package com.example.projecttest.model.entityproduct;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="tag")
@Table(name="tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Product> likes;
}

