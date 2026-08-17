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

    public OrgOfficer register(Long organizationId, OrgOfficer officer) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with id: " + organizationId));
        officerRepository.findByDlsuEmail(officer.getDlsuEmail()).ifPresent(existing -> {
            throw new IllegalArgumentException("An account with this DLSU email already exists.");
        });
        officer.setOrganization(organization);
        return officerRepository.save(officer);
    }
}