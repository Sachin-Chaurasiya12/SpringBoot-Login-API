package com.practice.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.model.Users;
import com.practice.security.service.JwtService;
import com.practice.security.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }
}
