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

@Configuration
public class DataSeeder implements CommandLineRunner {

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
