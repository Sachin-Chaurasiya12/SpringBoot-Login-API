package com.practice.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.security.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}