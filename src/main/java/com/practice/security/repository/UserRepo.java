package com.practice.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.security.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

    Users findUserByUsername(String username);
    
}
