import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { UserComponent } from "./user/user.component";
import { HeaderComponent } from "./header/header.component";
import { TaskComponent } from "./tasks/task/task.component";
import { FormsModule } from "@angular/forms";
import { TasksComponent } from "./tasks/tasks.component";
import { CardComponent } from "./shared/card/card.component";
import { NewTaskComponent } from "./tasks/new-task/new-task.component";

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        UserComponent,
        TaskComponent,
        TasksComponent,
        CardComponent,
        NewTaskComponent
    ],
    bootstrap: [AppComponent],
    imports: [FormsModule, BrowserModule]
})

export class AppModule {}