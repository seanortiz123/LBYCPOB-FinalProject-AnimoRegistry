package com.dlsu.animoregistry.web;

import com.dlsu.animoregistry.model.ApplicationForm;
import com.dlsu.animoregistry.model.ApplicationStatus;
import com.dlsu.animoregistry.service.ApplicationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class DashboardController {

    private final ApplicationService applicationService;

    public DashboardController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long studentId = (Long) session.getAttribute("userId");
        if (!"student".equals(session.getAttribute("role")) || studentId == null) {
            return "redirect:/login";
        }
}