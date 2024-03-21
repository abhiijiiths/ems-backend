package com.example.emsbackend.controller;


import com.example.emsbackend.entity.Department;
import com.example.emsbackend.entity.Organization;
import com.example.emsbackend.repository.DepartmentRepository;
import com.example.emsbackend.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    @PutMapping
    public ResponseEntity<Department> createNewDept(@RequestBody Department dept){
        Department department = departmentService.createNewDept(dept);
        return new ResponseEntity<>(department,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Department> deleteByid(@PathVariable("id") Long id){
        Department department = departmentService.deleteDept(id);
        return ResponseEntity.ok(department);
    }

}
