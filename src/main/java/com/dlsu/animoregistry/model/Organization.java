package com.dlsu.animoregistry.model;

public class Organization {

    private Long id;

    private String name;              // e.g. "LSCS", "animo.sys", "Green Media Group"
    private String category;          // e.g. "Academic", "Special Interest", "Community Service"
    private String description;
    private String logoUrl;
    private String socialMediaHandle;

    private boolean registrationOpen = true;
    private int membershipCap;
    private int currentMemberCount = 0;

    private double membershipFeeAmount;

    public Organization(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.membershipCap = membershipCap;
        this.membershipFeeAmount = membershipFeeAmount;
    }

    // ---- Registration status control (Executive Board Member user story) ----
    public void closeRegistration() {
        this.registrationOpen = false;
    }

    public void openRegistration() {
        this.registrationOpen = true;
    }

    // ---- Membership slot logic (Org Officer user story) ----
    public boolean hasAvailableSlot() {
        return currentMemberCount < membershipCap;
    }

    public void incrementMemberCount() {
        if (!hasAvailableSlot()) {
            throw new IllegalStateException("Membership cap already reached for " + name + ".");
        }
        this.currentMemberCount++;
        if (!hasAvailableSlot()) {
            this.registrationOpen = false;
        }
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

    public boolean isRegistrationOpen() {
        return registrationOpen;
    }

    public int getMembershipCap() {
        return membershipCap;
    }

    public void setMembershipCap(int membershipCap) {
        if (membershipCap < currentMemberCount) {
            throw new IllegalArgumentException(
                    "Membership cap cannot be lower than the current member count (" + currentMemberCount + ").");
        }
        this.membershipCap = membershipCap;
    }

    public int getCurrentMemberCount() {
        return currentMemberCount;
    }

    public double getMembershipFeeAmount() {
        return membershipFeeAmount;
    }

    public void setMembershipFeeAmount(double membershipFeeAmount) {
        this.membershipFeeAmount = membershipFeeAmount;
    }
}