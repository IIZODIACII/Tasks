package com.tasks.tasks.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tasks.tasks.models.Task;
import com.tasks.tasks.models.User;
import com.tasks.tasks.models.UserTasks;

@Service
public class TasksService {

    private List<Task> tasks;
    private UserService userService;

    TasksService(UserService userService) {
        this.userService = userService;
        
        tasks = new ArrayList<>(Arrays.asList(
            new Task(1, 1, "A task", "Simple Task"),
            new Task(2, 2, "B task", "Simple Task"),
            new Task(3, 2, "C task", "Simple Task"),
            new Task(4, 2, "D task", "Simple Task"),
            new Task(5, 3, "E task", "Simple Task"),
            new Task(6, 3, "F task", "Simple Task"),
            new Task(7, 4, "G task", "Simple Task"),
            new Task(8, 4, "H task", "Simple Task"),
            new Task(9, 4, "I task", "Simple Task")
            ));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public UserTasks getUserTasks(Integer userId) {
        User user = userService.loadUserData(userId);
        List<Task> userTasks = tasks.stream().filter(task -> task.getUserId() == user.getId()).collect(Collectors.toList());
        return new UserTasks(user, userTasks);
    }


    public void createNewTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(Task task) {
        int idx = getTaskIndex(task.getId());
        if(idx != -1) {
            tasks.set(getTaskIndex(task.getId()), task);
        }
    }

    public void deleteTask(Task task) {
        int idx = getTaskIndex(task.getId());
        if(idx != -1) {
            tasks.remove(idx);
        }
    }


    private int getTaskIndex(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == taskId){
                return i;
            }
        }
        return -1;
    }

}
