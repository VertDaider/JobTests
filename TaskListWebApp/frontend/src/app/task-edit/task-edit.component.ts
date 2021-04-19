import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  task = {};

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getTask(this.route.snapshot.params['id']);
  }

  getTask(id) {
    this.http.get('/tasks/'+id).subscribe(data => {
      this.task = data;
    });
  }

  updateTask(id,data) {
    this.http.put('/tasks/'+id, data)
      .subscribe(res => {
          this.router.navigate(['/task']);
        }, (err) => {
          console.log(err);
        }
      );
  }
}