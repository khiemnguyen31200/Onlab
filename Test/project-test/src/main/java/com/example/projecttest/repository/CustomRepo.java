package com.example.projecttest.repository;



import java.util.List;
import java.util.stream.Collectors;


public interface CustomRepo<T> {
    public abstract List<T> SearchByEmailLastName (String email, String lastName);
    public abstract List<T> SearchByFirstLastName (String firstName, String lastName);
    public abstract List<T> SearchByLastName(String lastName);
    public abstract List<T> SearchByFirstName(String firstName);
}


