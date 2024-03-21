package com.example.emsbackend.services;

import com.example.emsbackend.entity.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAllOrganisation();
    Organization createNewOrg(Organization organization);
    Organization addDepApartmentToOrg(Long orgId, Long deptId);

    Organization delOrgById(Long id);
}
