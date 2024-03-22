package com.example.emsbackend.controller;

import com.example.emsbackend.entity.Organization;
import com.example.emsbackend.pojo.AddDepRequest;
import com.example.emsbackend.services.OrganizationService;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/org")
public class OrganisationController {
     @Autowired
     OrganizationService organizationService;
     @GetMapping
     public ResponseEntity<List<Organization>> getAllOrganization(){
         List<Organization> organizations = organizationService.getAllOrganisation();
         return ResponseEntity.ok(organizations);
     }
     @PostMapping
     public ResponseEntity<Organization> createNewOrg(@RequestBody Organization org){
         return new ResponseEntity<>(organizationService.createNewOrg(org),HttpStatus.CREATED);
     }
    @PutMapping("/add-dep")
    public ResponseEntity<Organization> setDeptToOrg(@RequestBody AddDepRequest depRequest){
        Organization org = organizationService.addDepApartmentToOrg(depRequest.getOrgId(), depRequest.getDeptId());
        return ResponseEntity.ok(org);
    }

    @DeleteMapping("{id}")
    public void delOrgById(@PathVariable Long id){
         Organization organization = organizationService.delOrgById(id);
    }
}


