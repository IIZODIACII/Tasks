package com.tasks.tasks.services;

import org.springframework.stereotype.Service;

import com.tasks.tasks.models.User;

@Service
public class UserService {
    
    public User loadUserData(Integer userId) {
        return new User(userId, "temp", "login", null);
    }

}
