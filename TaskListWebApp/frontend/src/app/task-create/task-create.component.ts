import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-task-create',
  templateUrl: './task-create.component.html',
  styleUrls: ['./task-create.component.css']
})
export class TaskCreateComponent implements OnInit {

  task = {};

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  saveTask() {
    this.http.post('/tasks', this.task)
      .subscribe(res => {
          this.router.navigate(['/task']);
        }, (err) => {
          console.log(err);
        }
      );
  }
}
