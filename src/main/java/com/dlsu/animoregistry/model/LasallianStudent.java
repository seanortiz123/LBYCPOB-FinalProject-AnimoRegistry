package com.dlsu.animoregistry.model;

import jakarta.persistence.Entity;

@Entity
public class LasallianStudent extends DLSUUser {
    private String college;
    private String yearLevel;
}
