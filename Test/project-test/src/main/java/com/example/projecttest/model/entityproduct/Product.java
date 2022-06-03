package com.example.projecttest.model.entityproduct;

import javax.persistence.*;


import lombok.Data;

import java.util.Set;

@Entity(name="product")
@Table(name="product")
@Data
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name="category_id")
        private Category category;



        @PreRemove
        public void preRemove() {category.remove(this);
        }

        @ManyToMany
        @JoinTable(name = "product_tag", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
        private Set<Tag> tags;

}

