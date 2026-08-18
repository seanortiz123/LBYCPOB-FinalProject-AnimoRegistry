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

        Organization gmg = new Organization(
                "Green Media Group",
                "Special Interest",
                "DLSU's premier media and broadcasting organization.",
                30,
                100.0,
                PaymentType.CASH
        );
        gmg.setSocialMediaHandle("@greenmediagroup");

        organizationRepository.save(gmg);

        LasallianStudent juan = new LasallianStudent(
                "12345678", "Juan Dela Cruz", "juan_delacruz@dlsu.edu.ph", "password123",
                "CCS", "1st Year"
        );
        LasallianStudent maria = new LasallianStudent(
                "23456789", "Maria Santos", "maria_santos@dlsu.edu.ph", "password123",
                "COB", "2nd Year"
        );
        studentRepository.save(juan);
        studentRepository.save(maria);

        OrgOfficer officer = new OrgOfficer(
                "34567890", "Anna Reyes", "anna_reyes@dlsu.edu.ph", "password123",
                lscs, "VP for Membership"
        );
        officerRepository.save(officer);

        System.out.println("=======================================================");
        System.out.println(" AnimoRegistry seeded with sample organizations, ");
        System.out.println(" students, and an officer. Try:");
        System.out.println("   GET  http://localhost:8080/api/organizations");
        System.out.println("   GET  http://localhost:8080/api/students");
        System.out.println("   GET  http://localhost:8080/api/officers/1/dashboard");
        System.out.println("=======================================================");

    }
}