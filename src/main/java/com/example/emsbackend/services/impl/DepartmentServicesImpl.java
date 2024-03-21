package com.example.emsbackend.services.impl;

import com.example.emsbackend.entity.Department;
import com.example.emsbackend.exception.ResourseNotFoundException;
import com.example.emsbackend.repository.DepartmentRepository;
import com.example.emsbackend.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DepartmentServicesImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Department createNewDept(Department dept) {
        return departmentRepository.save(dept);
    }

    @Override
    public Department deleteDept(Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(()->
                new ResourseNotFoundException("dept not found"));
        departmentRepository.deleteById(deptId);
        return department;
    }

}
