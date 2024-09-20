package com.tasks.tasks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tasks.tasks.models.Task;
import com.tasks.tasks.models.User;
import com.tasks.tasks.models.UserTasks;
import com.tasks.tasks.repositories.TasksRepo;

@Service
public class TasksService {

    private UserService userService;
    private TasksRepo tasksRepo;

    TasksService(UserService userService, TasksRepo tasksRepo) {
        this.userService = userService;
        this.tasksRepo = tasksRepo;
    }

    public List<Task> getTasks() {
        return tasksRepo.findAll();
    }

    public User getUserTasks(Integer userId) {
        User user = userService.loadUserData(userId);
        if (user != null) {
            user.setTasks(tasksRepo.findByUserId(userId));
        }
        return user;
    }

    public void createNewTask(Task task) {
        tasksRepo.save(task);
    }

    public void updateTask(Task task) {
        tasksRepo.save(task);

    }

    public void deleteTask(Task task) {
        tasksRepo.delete(task);
    }

}
