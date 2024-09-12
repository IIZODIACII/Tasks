package com.tasks.tasks.models;

import java.util.List;

public class UserTasks extends User {
    
    List<Task> userTasks;

    public UserTasks(User user, List<Task> userTasks) {
        super(user.getId(), user.getName(), user.getLoginName(), user.getPassword());
        this.userTasks = userTasks;
    }
    

    public List<Task> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<Task> userTasks) {
        this.userTasks = userTasks;
    }

}
