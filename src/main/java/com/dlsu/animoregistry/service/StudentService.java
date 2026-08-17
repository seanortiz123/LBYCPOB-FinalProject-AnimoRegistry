package com.dlsu.animoregistry.service;

import com.dlsu.animoregistry.model.LasallianStudent;
import com.dlsu.animoregistry.repository.LasallianStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final LasallianStudentRepository studentRepository;

    public StudentService(LasallianStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}