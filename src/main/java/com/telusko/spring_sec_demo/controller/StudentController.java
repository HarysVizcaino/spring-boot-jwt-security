package com.telusko.spring_sec_demo.controller;

import com.telusko.spring_sec_demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Naving", "Java"),
            new Student(2, "Kiran", "Blockchain")
    ));

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

}
