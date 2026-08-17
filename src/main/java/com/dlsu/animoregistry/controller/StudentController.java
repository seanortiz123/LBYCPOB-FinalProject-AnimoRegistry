package com.dlsu.animoregistry.controller;

import com.dlsu.animoregistry.model.LasallianStudent;
import com.dlsu.animoregistry.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public LasallianStudent register(@RequestBody LasallianStudent student) {
        return studentService.register(student);
    }

    @GetMapping
    public List<LasallianStudent> getAll() {
        return studentService.getAll();
    }
}