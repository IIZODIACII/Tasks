package com.tasks.repositories;

import org.springframework.stereotype.Repository;

import com.tasks.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsersRepo extends JpaRepository<User, Integer> {

    User findByLoginName(String username);

}
