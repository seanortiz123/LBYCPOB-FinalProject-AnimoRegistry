package com.dlsu.animoregistry.model;

public abstract class DLSUUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idNumber;
    private String name;
    private String dlsuEmail;

    @JsonIgnore
    private String password;
}
