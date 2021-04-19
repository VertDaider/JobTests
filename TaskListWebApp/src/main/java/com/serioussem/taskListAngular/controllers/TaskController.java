package com.serioussem.taskListAngular.controllers;

import com.serioussem.taskListAngular.domain.Task;
import com.serioussem.taskListAngular.exception.TaskNotFoundException;
import com.serioussem.taskListAngular.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public Iterable<Task> task() {
        return taskRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tasks")
    public Task save(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{id}")
    public Task show(@PathVariable Long id) throws TaskNotFoundException {
        return taskRepo.findById(id)//.get()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) throws TaskNotFoundException {
        Task taskId = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        Task t = taskRepo.findById(id).get();
        t.setText(task.getText());
        t.setDate(task.getDate());
        taskRepo.save(t);
        return task;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws TaskNotFoundException {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}