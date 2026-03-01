package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.model.Users;
import com.example.security.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager authManager;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user){
        user.setpassword(encoder.encode(user.getpassword()));
        return repo.save(user);
    }
    public String verify(Users user) {
        Authentication authentication = 
        authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getusername(), user.getpassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user);
        }
        return "Fail";
    }
    private void generateToken() {
        
    }
}
