package com.dlsu.animoregistry.model;

import jakarta.persistence.Entity;

@Entity
public class LasallianStudent extends DLSUUser {
    private String college;
    private String yearLevel;

    protected LasallianStudent() {
        super();
    }

    public LasallianStudent(String idNumber, String name, String dlsuEmail, String password,
                            String college, String yearLevel) {
        super(idNumber, name, dlsuEmail, password);
        this.college = college;
        this.yearLevel = yearLevel;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    @Override
    public String displayDashboard() {
        return String.format("Applicant Dashboard - %s (%s, %s)", getName(), college, yearLevel);
    }
}
