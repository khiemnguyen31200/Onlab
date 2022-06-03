package com.example.projecttest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Employee {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;

    public boolean SearchByEmailLastName(String semail, String slastName) {
        return (email.contains(semail)
                &&lastName.contains(slastName));
    }
    public boolean SearchByFirstLastName(String sFirstName, String slastName) {
        return (firstName.contains(sFirstName)
                ||lastName.contains(slastName));
    }
    public boolean SearchByLastName(String lastName) {
        return (firstName.contains(lastName));
    }
    public boolean SearchByFirstNameLow(String sFirstName) {
        return (firstName.toLowerCase().contains(sFirstName.toLowerCase()));
    }

}
