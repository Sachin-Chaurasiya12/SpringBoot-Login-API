package com.practice.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.security.model.Student;
import com.practice.security.repository.StudentRepo;

@Service
public class JpaService {

    @Autowired
    private StudentRepo repo;
    
    public void add(Student student){
        repo.save(student);
    }
    public void addAll(List<Student> student){
        repo.saveAll(student);
    }
    public List<Student> getstudents() {
        return repo.findAll();
    }
    public Student getstudentsById(int id) {
        return repo.findById(id).orElse(null);
    }
}
