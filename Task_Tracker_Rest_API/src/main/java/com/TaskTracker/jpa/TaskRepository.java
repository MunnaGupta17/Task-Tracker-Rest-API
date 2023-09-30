package com.TaskTracker.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.TaskTracker.models.Task;

@Service
public interface TaskRepository extends JpaRepository<Task, Long>{

}
