package com.tasks.tasks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.tasks.models.Task;
import com.tasks.tasks.models.UserTasks;
import com.tasks.tasks.services.TasksService;

import jakarta.websocket.server.PathParam;

@RestController
public class TasksController {

    TasksService tasksService;

    TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return tasksService.getTasks();
    }

    @GetMapping("/tasks/user_tasks")
    public UserTasks getMethodName(@PathParam("userId") Integer userId) {
        return tasksService.getUserTasks(userId);
    }

    @PostMapping("/tasks/add_task")
    public void createTask(@RequestBody Task task) {
        tasksService.createNewTask(task);

    }

    @PutMapping("/tasks/update_task")
    public void updateTask(@RequestBody Task task) {
        tasksService.updateTask(task);
    }

    @DeleteMapping("/tasks/delete_task")
    public void deleteTask(@RequestBody Task task) {
        tasksService.deleteTask(task);
    }

}
