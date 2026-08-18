package com.dlsu.animoregistry.web;

import com.dlsu.animoregistry.service.OrgOfficerService;
import com.dlsu.animoregistry.service.StudentService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {

    private final StudentService studentService;
    private final OrgOfficerService officerService;

    public AuthController(StudentService studentService, OrgOfficerService officerService) {
        this.studentService = studentService;
        this.officerService = officerService;
    }
}