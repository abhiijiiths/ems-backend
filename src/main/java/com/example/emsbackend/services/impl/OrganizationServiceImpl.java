package com.example.emsbackend.services.impl;

import com.example.emsbackend.entity.Department;
import com.example.emsbackend.entity.Organization;
import com.example.emsbackend.exception.ResourseNotFoundException;
import com.example.emsbackend.repository.DepartmentRepository;
import com.example.emsbackend.repository.OrganizationRepository;
import com.example.emsbackend.services.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Organization> getAllOrganisation() {
        return organizationRepository.findAll();
    }
    @Override
    public Organization createNewOrg(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization addDepApartmentToOrg(Long orgId, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(()->
                new ResourseNotFoundException("departmnet not found"));
        Organization organization = organizationRepository.findById(orgId).orElseThrow(()->
                new ResourseNotFoundException("organization not found"));
        department.setOrgId(orgId);
        departmentRepository.save(department);
        return organization;
    }

    @Override
    public Organization delOrgById(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("Org not found"));
        try {
            organizationRepository.deleteById(id);
        }catch (Exception DataIntegrityViolationException){
            throw new  ResourseNotFoundException("Assosiated with a Department");
        }
        return organization;
    }

}