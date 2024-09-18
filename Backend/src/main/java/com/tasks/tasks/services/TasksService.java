package com.tasks.tasks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tasks.tasks.models.Task;
import com.tasks.tasks.models.User;
import com.tasks.tasks.models.UserTasks;
import com.tasks.tasks.repositories.TasksRepo;

@Service
public class TasksService {

    // private List<Task> tasks;
    private UserService userService;
    private TasksRepo tasksRepo;

    TasksService(UserService userService, TasksRepo tasksRepo) {
        this.userService = userService;
        this.tasksRepo = tasksRepo;

        // tasks = new ArrayList<>(Arrays.asList(
        // new Task(1, 1, "A task", "Simple Task"),
        // new Task(2, 2, "B task", "Simple Task"),
        // new Task(3, 2, "C task", "Simple Task"),
        // new Task(4, 2, "D task", "Simple Task"),
        // new Task(5, 3, "E task", "Simple Task"),
        // new Task(6, 3, "F task", "Simple Task"),
        // new Task(7, 4, "G task", "Simple Task"),
        // new Task(8, 4, "H task", "Simple Task"),
        // new Task(9, 4, "I task", "Simple Task")));
    }

    public List<Task> getTasks() {
        return tasksRepo.findAll();
    }

    public User getUserTasks(Integer userId) {
        User user = userService.loadUserData(userId);
        user.setTasks(tasksRepo.findByUserId(userId));
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
