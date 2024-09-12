import { Component, inject, Input, output, signal } from '@angular/core';
import { Task } from '../task/task.model';
import { TasksService } from '../tasks.service';

@Component({
	selector: 'app-new-task',
	templateUrl: './new-task.component.html',
	styleUrl: './new-task.component.scss'
})
export class NewTaskComponent {

	// newTask: Task = {} as Task;
	newTask = signal<Task>({} as Task);
	close = output<void>();
	@Input({required: true}) userId!: string;
	private tasksService = inject(TasksService);

	onSubmit(){
		this.tasksService.addTask(this.newTask(), this.userId);
		this.close.emit();
	}
}
