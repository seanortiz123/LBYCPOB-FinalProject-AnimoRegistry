package com.dlsu.animoregistry.web;

import com.dlsu.animoregistry.model.ApplicationForm;
import com.dlsu.animoregistry.model.ApplicationStatus;
import com.dlsu.animoregistry.model.OrgOfficer;
import com.dlsu.animoregistry.model.Organization;
import com.dlsu.animoregistry.service.ApplicationService;
import com.dlsu.animoregistry.service.OrgOfficerService;
import com.dlsu.animoregistry.service.OrganizationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
@Controller
@RequestMapping("/officer")
public class OfficerController {

    private final OrgOfficerService officerService;
    private final OrganizationService organizationService;
    private final ApplicationService applicationService;

    public OfficerController(OrgOfficerService officerService, OrganizationService organizationService,
                             ApplicationService applicationService) {
        this.officerService = officerService;
        this.organizationService = organizationService;
        this.applicationService = applicationService;
    }

    private Long requireOfficerOrgId(HttpSession session) {
        if (!"officer".equals(session.getAttribute("role"))) return null;
        return (Long) session.getAttribute("organizationId");
    }
    @GetMapping
    public String panel(@RequestParam(required = false) ApplicationStatus status,
                        HttpSession session, Model model) {
        Long orgId = requireOfficerOrgId(session);
        if (orgId == null) return "redirect:/login";

        Long officerId = (Long) session.getAttribute("userId");
        OrgOfficer officer = officerService.getById(officerId);
        Organization org = organizationService.getById(orgId);

        List<ApplicationForm> apps = status != null
                ? applicationService.getByOrganizationAndStatus(orgId, status)
                : applicationService.getByOrganization(orgId);
        apps.sort(Comparator.comparing(ApplicationForm::getDateApplied).reversed());

        model.addAttribute("title", "Officer panel");
        model.addAttribute("officer", officer);
        model.addAttribute("org", org);
        model.addAttribute("applications", apps);
        model.addAttribute("selectedStatus", status);
        model.addAttribute("statuses", ApplicationStatus.values());
        return "officer";
    }
}