package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.model.Users;
import com.example.security.model.UsersPrincipal;
import com.example.security.repository.UserRepo;

@Service
public class myUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = repo.findByUsername(username);
       if(user == null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not found");
       }
       return new UsersPrincipal(user);
    }
    
}
