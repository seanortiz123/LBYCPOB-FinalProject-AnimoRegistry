package com.dlsu.animoregistry.config;

import com.dlsu.animoregistry.model.Organization;
import com.dlsu.animoregistry.model.PaymentType;
import com.dlsu.animoregistry.repository.LasallianStudentRepository;
import com.dlsu.animoregistry.repository.OrgOfficerRepository;
import com.dlsu.animoregistry.repository.OrganizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private final OrganizationRepository organizationRepository;
    private final LasallianStudentRepository studentRepository;
    private final OrgOfficerRepository officerRepository;

    public DataSeeder(OrganizationRepository organizationRepository,
                      LasallianStudentRepository studentRepository,
                      OrgOfficerRepository officerRepository) {
        this.organizationRepository = organizationRepository;
        this.studentRepository = studentRepository;
        this.officerRepository = officerRepository;
    }

    @Override
    public void run(String... args) {
        Organization lscs = new Organization(
                "La Salle Computer Society (LSCS)",
                "Academic",
                "The official student organization for Computer Science, IT, and related programs in DLSU.",
                50,
                150.0,
                PaymentType.CASH
        );
        lscs.setSocialMediaHandle("@dlsu.lscs");

        Organization animoSys = new Organization(
                "ACCESS",
                "Academic",
                "DLSU's organization for Computer Engineering students, focused on dev culture and hackathons.",
                40,
                200.0,
                PaymentType.DIGITAL_BANK
        );
        animoSys.setSocialMediaHandle("@dlsu.animosys");

        organizationRepository.save(lscs);
        organizationRepository.save(animoSys);
    }
}