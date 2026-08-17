package com.dlsu.animoregistry.service;

import com.dlsu.animoregistry.model.OrgOfficer;
import com.dlsu.animoregistry.repository.OrgOfficerRepository;
import com.dlsu.animoregistry.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgOfficerService {

    private final OrgOfficerRepository officerRepository;
    private final OrganizationRepository organizationRepository;

    public OrgOfficerService(OrgOfficerRepository officerRepository, OrganizationRepository organizationRepository) {
        this.officerRepository = officerRepository;
        this.organizationRepository = organizationRepository;
    }
}