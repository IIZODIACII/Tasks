package com.tasks.tasks.repositories;

import org.springframework.stereotype.Repository;

import com.tasks.tasks.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsersRepo extends JpaRepository<User, Integer> {

}
