package com.telusko.spring_sec_demo.service;

import com.telusko.spring_sec_demo.model.User;
import com.telusko.spring_sec_demo.model.UserPrincipal;
import com.telusko.spring_sec_demo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User 404");
        }

         return new UserPrincipal(user);
    }
}
