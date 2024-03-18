package com.example.emsbackend.controller;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }


    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,@RequestBody EmployeeDto updateEmployee){
        EmployeeDto updatedEmploye = employeeService.updateEmployeeByid(id,updateEmployee);
        return ResponseEntity.ok(updatedEmploye);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        employeeService.deleteEmpoloyeeById(id);
        return ResponseEntity.ok("Employe with id "+ id + "has been deleted");
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<EmployeeDto>geyByname(@PathVariable("name") String name){
        EmployeeDto employee = employeeService.getEmployeeByName(name);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeDto>geyemail(@PathVariable("email") String email){
        EmployeeDto employee = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("age-upto/{age}")
    public ResponseEntity<List<EmployeeDto>> getEmployeeUnderAge(@PathVariable Integer age){
        List<EmployeeDto> employees = employeeService.getEmployeeUnderAge(age);
        return ResponseEntity.ok(employees);
    }
}
