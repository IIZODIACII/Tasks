import { Component, Input, inject } from '@angular/core';
import { TasksService } from '../tasks.service';
import { Task } from './task.model';
@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrl: './task.component.scss'
})
export class TaskComponent {
	
	@Input({required: true}) task!: Task;
	private tasksService = inject(TasksService);

	onComplete() {
		this.tasksService.removeTask(this.task.id);
	}

}
