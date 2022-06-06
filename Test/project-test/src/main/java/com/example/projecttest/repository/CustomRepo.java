package com.example.projecttest.repository;



import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface CustomRepo<T> {
    public abstract List<T> SearchByEmailLastName (String email, String lastName);
    public abstract List<T> SearchByFirstLastName (String firstName, String lastName);
    public abstract List<T> SearchByLastName(String lastName);
    public abstract List<T> SearchByFirstName(String firstName);
}


