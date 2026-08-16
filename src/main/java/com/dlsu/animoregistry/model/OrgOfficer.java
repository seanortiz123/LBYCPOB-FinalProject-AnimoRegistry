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

    protected OrgOfficer() {
        super();
    }

    public OrgOfficer(String idNumber, String name, String dlsuEmail, String password,
                      Organization organization, String position) {
        super(idNumber, name, dlsuEmail, password);
        this.organization = organization;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}