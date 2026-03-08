package com.practice.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.security.dtoModel.LoginRequest;
import com.practice.security.dtoModel.RegisterRequest;
import com.practice.security.dtoModel.ResponseDTO;
import com.practice.security.model.Users;
import com.practice.security.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public ResponseDTO register(RegisterRequest dto){
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        Users saveduser = repo.save(user);
        return new ResponseDTO(
            saveduser.getId(),
            saveduser.getUsername()
        );
    }
    public String verify(LoginRequest dto) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(dto.getUsername());
        }else{
            return "fail";

        }
    }
}