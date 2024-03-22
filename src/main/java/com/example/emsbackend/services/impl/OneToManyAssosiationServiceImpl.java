package com.example.emsbackend.services.impl;

import com.example.emsbackend.entity.Department;
import com.example.emsbackend.entity.Organization;
import com.example.emsbackend.exception.ResourseNotFoundException;
import com.example.emsbackend.repository.DepartmentRepository;
import com.example.emsbackend.repository.OrganizationRepository;
import com.example.emsbackend.services.OneMAnyAssosiationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class OneToManyAssosiationServiceImpl implements OneMAnyAssosiationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    // OrganizationServices
    @Override
    public Organization createNewOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
    @Override
    public void delOrganizationById(Long id) {
        organizationRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("org dosent exist"));
//        try {
//            departmentRepository.deleteByOrgId(id);
//        }catch (Exception e){
//            System.out.println(e);
//            throw new ResourseNotFoundException("e");
//        }

        organizationRepository.deleteById(id);
    }
    @Override
    public ResponseEntity<?> delOrgWithoutDept(Long id) {
        organizationRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("org not found"));
        List<Department> depts = departmentRepository.findByOrgId(id);
        if (depts.isEmpty()){
            organizationRepository.deleteById(id);
            return ResponseEntity.ok().body("deleted");
        }
        return ResponseEntity.badRequest().body("CAnt not delete");
    }



    // DepartmentServices
    @Override
    public ResponseEntity<?> createNewDepartment(Department department) {
        Organization org = organizationRepository.findById(department.getOrgId()).orElse(null);
        if (org == null){
            return ResponseEntity.badRequest().body("Organization doesn't exist");
        }
        departmentRepository.save(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @Override
    public Map<String, Boolean> deleteDepartmentById(Long id) {
        departmentRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("dept doesnt exist"));
        departmentRepository.deleteById(id);
        Map<String,Boolean> responce = new HashMap<>();
        responce.put("deleted",Boolean.TRUE);
        return responce;
    }
    @Override
    public List<Department> getDepartmentByOrgId(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("Org not found"));

        List<Department> departments = departmentRepository.findByOrgId(id);
        return departments;
    }

}
