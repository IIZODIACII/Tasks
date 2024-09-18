package com.tasks.tasks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.tasks.models.Task;

@Repository
public interface TasksRepo extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
}
