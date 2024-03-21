package com.example.emsbackend.services;

import com.example.emsbackend.entity.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department createNewDept(Department dept);
    Department deleteDept(Long deptId);
}
