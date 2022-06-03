package com.example.projecttest.controller;

import com.example.projecttest.model.Employee;
import com.example.projecttest.repository.EmployeeRepository;
import com.example.projecttest.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private EmployerService employerService;

    @PostMapping("/search-by-email-lastname")
    public List<Employee> SearchEmailLastName(@RequestBody Employee employee){
        return employerService.SearchByEmailLastName(employee.getEmail(), employee.getLastName());
    }
    @PostMapping("/search-by-first-lastname")
    public List<Employee> SearchFirstLastName(@RequestBody Employee employee){
        return employerService.SearchByFirstLastName(employee.getFirstName(), employee.getLastName());
    }
    @PostMapping("/search-by-lastname-order-by-firstname")
    public List<Employee> SearchLastName(@RequestBody Employee employee){
        return employerService.SearchByLastName(employee.getLastName());
    }
    @PostMapping("/search-by-email-firstname")
    public List<Employee> SearchFirstName(@RequestBody Employee employee){
        return employerService.SearchByFirstName(employee.getFirstName());
    }
}
