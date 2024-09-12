import { Injectable } from "@angular/core";
import { dummyTasks, Task } from "./task/task.model";



@Injectable({
    providedIn: 'root'
})
export class TasksService {
    private tasks = dummyTasks;

    constructor() {
        const tasks = localStorage.getItem('tasks');

        if(tasks) {
            this.tasks = JSON.parse(tasks);
        }
    }


    getUserTasks(userId: string) {
        return this.tasks.filter(task => task.userId === userId);
    }

    addTask(task: Task, userId: string) {
		task.userId = userId;
		task.id = new Date().getTime().toString();
		this.tasks.unshift(task);
        this.saveTasks();
	}

    removeTask(taskId: string) {
        this.tasks = this.tasks.filter(originalTask => originalTask.id !== taskId);
        this.saveTasks();
    }

    private saveTasks() {
        localStorage.setItem('tasks', JSON.stringify(this.tasks));
    }
}