package com.telusko.spring_sec_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.telusko.spring_sec_demo.model.User;
import com.telusko.spring_sec_demo.repo.UserRepository;

@Component
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) { 
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }
}
