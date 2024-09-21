package com.tasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.models.User;
import com.tasks.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add_user")
    public void createUser(@RequestBody User user) {
        userService.createNewUser(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping("/update_user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/delete_user")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

}
