package com.practice.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.dtoModel.LoginRequest;
import com.practice.security.dtoModel.RegisterRequest;
import com.practice.security.dtoModel.ResponseDTO;
import com.practice.security.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping("/register")
    public ResponseDTO register(@RequestBody RegisterRequest register){
        return service.register(register);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest login){
        return service.verify(login);
    }
}
