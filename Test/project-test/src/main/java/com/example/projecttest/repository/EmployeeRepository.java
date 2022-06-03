package com.example.projecttest.repository;

import com.example.projecttest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>,CustomRepo<Employee>{
}
