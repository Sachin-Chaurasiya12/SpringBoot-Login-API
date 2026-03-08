package com.practice.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.security.model.Users;
import com.practice.security.model.Usersprincipal;
import com.practice.security.repository.UserRepo;

@Service
public class myUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = repo.findUserByUsername(username);
       if(user == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
       }

       return new Usersprincipal(user);
    }
    
}
