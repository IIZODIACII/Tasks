package com.tasks.tasks.services;

import org.springframework.stereotype.Service;

import com.tasks.tasks.models.User;
import com.tasks.tasks.repositories.UsersRepo;

@Service
public class UserService {

    private UsersRepo usersRepo;

    UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public User loadUserData(Integer userId) {
        return usersRepo.findById(userId).orElse(null);
    }

}
