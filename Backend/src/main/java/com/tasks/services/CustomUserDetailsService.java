package com.tasks.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tasks.models.User;
import com.tasks.models.UserPrinciple;
import com.tasks.repositories.UsersRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsersRepo usersRepo;

    public CustomUserDetailsService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepo.findByLoginName(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found!");
        }

        return new UserPrinciple(user);
    }
}
