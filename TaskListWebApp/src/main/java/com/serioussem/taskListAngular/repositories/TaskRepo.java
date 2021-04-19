package com.serioussem.taskListAngular.repositories;

import com.serioussem.taskListAngular.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
}
