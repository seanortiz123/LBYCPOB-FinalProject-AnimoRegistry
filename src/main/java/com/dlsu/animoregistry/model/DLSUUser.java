package com.dlsu.animoregistry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DLSUUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private String password;

    protected DLSUUser() {
    }

    private String idNumber;
    private String name;
    private String dlsuEmail;

    protected DLSUUser(String idNumber, String name, String dlsuEmail, String password) {
        setIdNumber(idNumber);
        this.name = name;
        setDlsuEmail(dlsuEmail);
        this.password = password;
    }

    public void setIdNumber(String idNumber) {
        if (idNumber == null || !idNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException(
                    "Invalid DLSU ID Number. It must be exactly 8 digits (e.g., 12345678).");
        }
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setDlsuEmail(String dlsuEmail) {
        if (dlsuEmail == null || !dlsuEmail.trim().toLowerCase().endsWith("@dlsu.edu.ph")) {
            throw new IllegalArgumentException(
                    "Invalid email. Only official @dlsu.edu.ph addresses may register.");
        }
        this.dlsuEmail = dlsuEmail.trim().toLowerCase();
    }

    public String getDlsuEmail() {
        return dlsuEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters.");
        }
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public abstract String displayDashboard();
}