package com.example.emsbackend.services;

import com.example.emsbackend.entity.Department;
import com.example.emsbackend.entity.Organization;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface OneMAnyAssosiationService {

    // Organization Cruds
    Organization createNewOrganization(Organization organization);
    void delOrganizationById(Long id);
    ResponseEntity<?> delOrgWithoutDept(Long id);



    //Department cruds
    ResponseEntity<?> createNewDepartment(Department department);
    Map<String ,Boolean> deleteDepartmentById(Long id);
    List<Department> getDepartmentByOrgId(Long id);

}
