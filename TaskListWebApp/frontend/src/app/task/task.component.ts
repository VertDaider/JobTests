import { HttpClient } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  constructor(private http: HttpClient) { }
  tasks: any;

  ngOnInit() {
  this.http.get('/tasks').subscribe(data => {
    this.tasks = data;
  });
  }

}
