package com.example.emsbackend.services;

import com.example.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployeeByid(Long id,EmployeeDto updatedEmployee);
    void deleteEmpoloyeeById(Long id);
    EmployeeDto getEmployeeByName(String name);
    EmployeeDto getEmployeeByEmail(String email);
    List<EmployeeDto> getEmployeeUnderAge(Integer age);
}
