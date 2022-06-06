package com.example.projecttest.repository;

import com.example.projecttest.model.Employee;
import java.util.List;



public class CustomRepoImpl implements CustomRepo<Employee>{
    @Override
    public List<Employee> SearchByEmailLastName(String email, String lastName) {
        return null;
    }

    @Override
    public List<Employee> SearchByFirstLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Employee> SearchByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Employee> SearchByFirstName(String firstName) {
        return null;
    }

//    @Autowired private EmployeeRepository employeeRepository;
//
//    @Override
//    public List<Employee> SearchByEmailLastName(String email, String lastName) {
//        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByEmailLastName(email,lastName)).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Employee> SearchByFirstLastName(String firstName, String lastName) {
//        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByEmailLastName(firstName,lastName)).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Employee> SearchByLastName(String lastName) {
//        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByLastName(lastName)).sorted((o1,o2) -> (o1.getFirstName().compareTo(o2.getFirstName()))).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Employee> SearchByFirstName(String firstName) {
//        return employeeRepository.findAll().stream().filter(employee -> employee.SearchByFirstNameLow(firstName)).collect(Collectors.toList());
//    }
}


