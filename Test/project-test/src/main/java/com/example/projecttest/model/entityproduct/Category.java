package com.example.projecttest.model.entityproduct;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="category")
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        product.setCategory(this);
        products.add(product);
    }

    public void remove(Product product) {
        product.setCategory(null);
        products.remove(product);
    }


    @PreRemove
    public void preRemove() {
        products.stream().forEach(p -> p.setCategory(null));
        products.clear();
    }
}
