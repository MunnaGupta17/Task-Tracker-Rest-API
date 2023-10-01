package com.TaskTracker.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.TaskTracker.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
