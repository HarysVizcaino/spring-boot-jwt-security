package com.telusko.spring_sec_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.spring_sec_demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}