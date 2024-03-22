package com.example.emsbackend.controller;

import com.example.emsbackend.entity.Department;
import com.example.emsbackend.entity.Organization;
import com.example.emsbackend.repository.DepartmentRepository;
import com.example.emsbackend.repository.OrganizationRepository;
import com.example.emsbackend.services.OneMAnyAssosiationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/assosiate")
public class OneToManyAssociationController {

    @Autowired
    OneMAnyAssosiationService oneMAnyAssosiationService;

    @PostMapping("org")
    public ResponseEntity<Organization> createNewOrg(@RequestBody Organization organization){
        Organization org = oneMAnyAssosiationService.createNewOrganization(organization);
        return new ResponseEntity<>(org, HttpStatus.CREATED);
    }
    @DeleteMapping("org-admin/{id}")
    public void delOrgById (@PathVariable("id") Long id){
        oneMAnyAssosiationService.delOrganizationById(id);

    }

    @DeleteMapping("org/{id}")
    public ResponseEntity<?> delIfNotAssociated(@PathVariable("id") Long id){
        return oneMAnyAssosiationService.delOrgWithoutDept(id);
    }

    @PostMapping("dept")
    public  ResponseEntity<?> createNewDept(@RequestBody Department dept){
        ResponseEntity<?> department = oneMAnyAssosiationService.createNewDepartment(dept);
        return department;
    }
    @DeleteMapping("dept/{id}")
    public Map<String,Boolean> deleteDeptById(@PathVariable("id") Long id){
        return oneMAnyAssosiationService.deleteDepartmentById(id);
    }

    @GetMapping("dept-orgid/{id}")
    public ResponseEntity<List<Department>> getALlDepByOrgId(@PathVariable("id") Long id){
        List<Department> depts = oneMAnyAssosiationService.getDepartmentByOrgId(id);
        return ResponseEntity.ok(depts);
    }

}
