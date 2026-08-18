package com.dlsu.animoregistry.web;

import com.dlsu.animoregistry.model.LasallianStudent;
import com.dlsu.animoregistry.model.OrgOfficer;
import com.dlsu.animoregistry.service.OrgOfficerService;
import com.dlsu.animoregistry.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final StudentService studentService;
    private final OrgOfficerService officerService;

    public AuthController(StudentService studentService, OrgOfficerService officerService) {
        this.studentService = studentService;
        this.officerService = officerService;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("title", "Log in");
        return "login";
    }
}