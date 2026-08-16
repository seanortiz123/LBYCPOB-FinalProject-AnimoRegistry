package com.dlsu.animoregistry.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrgOfficer extends DLSUUser {

    private String position;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    
}