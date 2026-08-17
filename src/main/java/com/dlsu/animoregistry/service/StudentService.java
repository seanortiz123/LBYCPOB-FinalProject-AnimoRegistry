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

    public LasallianStudent register(LasallianStudent student) {
        studentRepository.findByDlsuEmail(student.getDlsuEmail()).ifPresent(existing -> {
            throw new IllegalArgumentException("An account with this DLSU email already exists.");
        });
        studentRepository.findByIdNumber(student.getIdNumber()).ifPresent(existing -> {
            throw new IllegalArgumentException("An account with this ID number already exists.");
        });
        return studentRepository.save(student);
    }
}