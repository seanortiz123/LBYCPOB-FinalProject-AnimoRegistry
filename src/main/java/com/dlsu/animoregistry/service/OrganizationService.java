package com.dlsu.animoregistry.service;

import com.dlsu.animoregistry.model.Organization;
import com.dlsu.animoregistry.repository.OrganizationRepository;

import java.util.List;

public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization create(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public List<Organization> getOpenForRegistration() {
        return organizationRepository.findByRegistrationOpenTrue();
    }

    public List<Organization> getByCategory(String category) {
        return organizationRepository.findByCategoryIgnoreCase(category);
    }
}
