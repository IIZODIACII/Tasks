import { Component, Input, output } from '@angular/core';
import { User } from '../app.component';


@Component({
	selector: 'app-user',
	templateUrl: './user.component.html',
	styleUrl: './user.component.scss'
})
export class UserComponent {
	
	@Input() user!: User;
	@Input({required: true}) selected!: boolean;
	onSelect= output<User>();

	get imagePath() {
		return 'assets/users/' + this.user.avatar;
	}

	onUserClick() {
		this.onSelect.emit(this.user);
	}




}



