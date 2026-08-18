package com.dlsu.animoregistry.web;

import com.dlsu.animoregistry.model.ApplicationStatus;
import com.dlsu.animoregistry.model.OrgOfficer;
import com.dlsu.animoregistry.model.Organization;
import com.dlsu.animoregistry.service.ApplicationService;
import com.dlsu.animoregistry.service.OrgOfficerService;
import com.dlsu.animoregistry.service.OrganizationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}