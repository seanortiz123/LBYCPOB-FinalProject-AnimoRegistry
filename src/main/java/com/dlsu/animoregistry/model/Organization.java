package com.dlsu.animoregistry.model;

public class Organization {

    private Long id;

    private String name;              // e.g. "LSCS", "animo.sys", "Green Media Group"
    private String category;          // e.g. "Academic", "Special Interest", "Community Service"
    private String description;
    private String logoUrl;
    private String socialMediaHandle;

    public Organization(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    // ---- Getters / Setters (Central Committee Member profile-editing user story) ----
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSocialMediaHandle() {
        return socialMediaHandle;
    }

    public void setSocialMediaHandle(String socialMediaHandle) {
        this.socialMediaHandle = socialMediaHandle;
    }
}