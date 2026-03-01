package com.example.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.model.Users;
import com.example.security.service.UserService;

@RestController
public class UserController {
    private UserService service;
    public UserController(UserService service){
        this.service = service;
    }
    @PostMapping("/register")
    public Users addUser(@RequestBody Users user){
        return service.register(user);
    }
    @PostMapping("/login")
    public String Login(@RequestBody Users user){
        return service.verify(user);
    }
}
