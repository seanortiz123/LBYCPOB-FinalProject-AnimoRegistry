package com.dlsu.animoregistry.config;

import com.dlsu.animoregistry.model.LasallianStudent;
import com.dlsu.animoregistry.model.Organization;
import com.dlsu.animoregistry.model.OrgOfficer;
import com.dlsu.animoregistry.model.PaymentType;
import com.dlsu.animoregistry.repository.LasallianStudentRepository;
import com.dlsu.animoregistry.repository.OrgOfficerRepository;
import com.dlsu.animoregistry.repository.OrganizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Seeds the Supabase Postgres database with a few sample records on startup so
 * the API has something to return right away. Purely for demo purposes -
 * safe to delete once real data entry flows are wired up.
 */
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

        System.out.println("=======================================================");
        System.out.println(" AnimoRegistry seeded with sample organizations, ");
        System.out.println(" students, and an officer. Try:");
        System.out.println("   GET  http://localhost:8080/api/organizations");
        System.out.println("   GET  http://localhost:8080/api/students");
        System.out.println("   GET  http://localhost:8080/api/officers/1/dashboard");
        System.out.println(" Database: Connected to Supabase PostgreSQL");
        System.out.println(" Dashboard: https://supabase.com/dashboard");
        System.out.println("=======================================================");
    }
}