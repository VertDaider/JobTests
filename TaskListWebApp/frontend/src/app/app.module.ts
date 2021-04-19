import { RouterModule, Routes } from '@angular/router';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TaskComponent } from './task/task.component';
import { TaskDetailComponent } from './task-detail/task-detail.component';
import { TaskCreateComponent } from './task-create/task-create.component';
import { TaskEditComponent } from './task-edit/task-edit.component';

const appRoutes: Routes = [
  {
    path: 'task',
    component: TaskComponent,
    data: { title: 'Task List' }
  },
  {
    path: 'task-detail/:id',
    component: TaskDetailComponent,
    data: { title: 'Task Details' }
  },
  {
    path: 'task-create',
    component: TaskCreateComponent,
    data: { title: 'Create Task' }
  },
  {
    path: 'task-edit/:id',
    component: TaskEditComponent,
    data: { title: 'Edit Task' }
  },
  { path: '',
    redirectTo: '/task',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    TaskDetailComponent,
    TaskCreateComponent,
    TaskEditComponent
  ],
  imports: [
  	BrowserModule,
  	FormsModule,
  	HttpClientModule,
    RouterModule.forRoot(
    appRoutes,
    { enableTracing: true }
  )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
