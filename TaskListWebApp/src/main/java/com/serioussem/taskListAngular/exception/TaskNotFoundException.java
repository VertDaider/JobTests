package com.serioussem.taskListAngular.exception;

public class TaskNotFoundException extends Exception {
    private Long id;

    public TaskNotFoundException(long id) {
        super(String.format("Task is not found with id : '%s'", id));
    }
}
