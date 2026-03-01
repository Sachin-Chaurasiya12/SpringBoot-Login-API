package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.model.Users;
import com.example.security.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user){
        user.setpassword(encoder.encode(user.getpassword()));
        return repo.save(user);
    }
}
