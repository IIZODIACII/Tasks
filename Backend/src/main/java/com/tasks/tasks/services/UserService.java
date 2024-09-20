package com.tasks.tasks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tasks.tasks.models.User;
import com.tasks.tasks.repositories.UsersRepo;

@Service
public class UserService {

    private UsersRepo usersRepo;

    UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public List<User> getAllUsers() {
        return usersRepo.findAll();
    }

    public User loadUserData(Integer userId) {
        return usersRepo.findById(userId).orElse(null);
    }

    public void createNewUser(User user) {
        usersRepo.save(user);
    }

    public void updateUser(User user) {
        usersRepo.save(user);

    }

    public void deleteUser(User user) {
        usersRepo.delete(user);
    }

}
