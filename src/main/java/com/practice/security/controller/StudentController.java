package com.practice.security.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.model.Student;
import com.practice.security.service.JpaService;

@RestController
public class StudentController {
    @Autowired
    private JpaService service;
    
    @PostMapping("/student")
    public Student addStudents(@RequestBody Student student){
        service.add(student);
        return student;
    }
    @PostMapping("/students")
    public List<Student> addStudents(@RequestBody List<Student> student){
        service.addAll(student);
        return student;
    }
    @GetMapping("/students")
    public List<Student> getStudent(){
        return service.getstudents();
    }
    @GetMapping("/student/{id}")
    public Student getStudentbyid(@PathVariable int id){
        return service.getstudentsById(id);
    }
}
