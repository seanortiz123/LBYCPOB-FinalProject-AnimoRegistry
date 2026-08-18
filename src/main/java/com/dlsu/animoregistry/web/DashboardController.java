package com.dlsu.animoregistry.web;

import com.dlsu.animoregistry.service.ApplicationService;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {

    private final ApplicationService applicationService;

    public DashboardController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
}