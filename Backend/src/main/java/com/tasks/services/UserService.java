package com.tasks.services;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tasks.models.User;
import com.tasks.repositories.UsersRepo;

@Service
public class UserService {

    private UsersRepo usersRepo;
    private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder(12);

    AuthenticationManager authenticationManager;
    JWTService jwtService;

    UserService(AuthenticationManager authenticationManager, UsersRepo usersRepo, JWTService jwtService) {
        this.usersRepo = usersRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public List<User> getAllUsers() {
        return usersRepo.findAll();
    }

    public User loadUserData(Integer userId) {
        return usersRepo.findById(userId).orElse(null);
    }

    public void createNewUser(User user) {
        user.setPassword(passEncoder.encode(user.getPassword()));
        usersRepo.save(user);
    }

    public void updateUser(User user) {
        if (user.getPassword() != null) {
            user.setPassword(passEncoder.encode(user.getPassword()));
        }
        usersRepo.save(user);

    }

    public void deleteUser(User user) {
        usersRepo.delete(user);
    }

    public String login(User user) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getLoginName(), user.getPassword()));

        if (auth.isAuthenticated()) {
            return jwtService.generateToken(user.getLoginName());
        }

        return "fail";
    }

}
