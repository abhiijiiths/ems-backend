package com.example.emsbackend.repository;

import com.example.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstName(String firstName);
    Employee findByEmail(String email);
    List<Employee> findByAgeLessThan(Integer age);
}