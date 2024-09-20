package com.tasks.tasks.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.tasks.models.Task;
import com.tasks.tasks.models.User;
import com.tasks.tasks.services.TasksService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    TasksService tasksService;

    TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    public List<Task> getAllTasks() {
        return tasksService.getTasks();
    }

    @GetMapping("/user_tasks")
    public ResponseEntity<User> getMethodName(@PathParam("userId") Integer userId) {
        User user = tasksService.getUserTasks(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add_task")
    public void createTask(@RequestBody Task task) {
        tasksService.createNewTask(task);

    }

    @PutMapping("/update_task")
    public void updateTask(@RequestBody Task task) {
        tasksService.updateTask(task);
    }

    @DeleteMapping("/delete_task")
    public void deleteTask(@RequestBody Task task) {
        tasksService.deleteTask(task);
    }

}
