package com.dlsu.animoregistry.model;

import jakarta.persistence.Entity;

@Entity
public class LasallianStudent extends DLSUUser {
    private String college;
    private String yearLevel;


    @Override
    public String displayDashboard() {
        return String.format("Applicant Dashboard - %s (%s, %s)", getName(), college, yearLevel);
    }
}
