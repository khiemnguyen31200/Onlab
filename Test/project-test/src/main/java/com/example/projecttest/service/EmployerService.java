package com.example.projecttest.service;

import com.example.projecttest.model.Employee;
import com.example.projecttest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> SearchByEmailLastName (String email, String lastName){
        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByEmailLastName(email,lastName)).collect(Collectors.toList());
}
    public List<Employee> SearchByFirstLastName (String firstName, String lastName){
        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByEmailLastName(firstName,lastName)).collect(Collectors.toList());
    }
    public List<Employee> SearchByLastName(String lastName){
        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByLastName(lastName)).sorted((o1,o2) -> (o1.getFirstName().compareTo(o2.getFirstName()))).collect(Collectors.toList());
    }
    public List<Employee> SearchByFirstName(String firstName){
        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByFirstNameLow(firstName)).collect(Collectors.toList());
    }
}
