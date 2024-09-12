import { Component } from '@angular/core';
import { DUMMY_USERS } from './user/dummy-users';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrl: './app.component.scss'
})
export class AppComponent {
	title = 'project';
	users: User[] = DUMMY_USERS;
	selectedUser?: User;

	onUserSelect(selectedUser: User) {
		this.selectedUser = selectedUser;
	}

}


export interface User {
	id: string
	name: string
	avatar: string
}
