package com.example.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    public List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Sachin", 80),
        new Student(2, "Akash", 70)
    ));
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @PostMapping("csrf-token")
    public CsrfToken addToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("-csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
