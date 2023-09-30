package com.TaskTracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskTracker.exceptions.InvalidTaskException;
import com.TaskTracker.exceptions.ResourceNotFoundException;
import com.TaskTracker.jpa.TaskRepository;
import com.TaskTracker.models.Task;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

/**
 * Service class for managing tasks.
 */

@Service
public class TaskServicesImpl implements TaskServices{

	@Autowired
	private TaskRepository taskRepository;
	
	/**
     * Adds a new task to the database.
     *
     * @param task to add new task to database.
     * @return The added task.
     * @throws InvalidTaskException if the task data is invalid.
     */
	@Override
	public Task addTask(Task task) throws InvalidTaskException {
		
		// Validate the task data, and throw InvalidTaskException if it's not valid.
        if (!isValidTask(task)) {
            throw new InvalidTaskException("Invalid task data");
        }

        // Save the task to the database
        return taskRepository.save(task);
	}

	/**
	 * Edits an existing task with the provided task ID.
	 *
	 * @param taskId of the task to edit.
	 * @param updatedTask to update task data.
	 * @return The edited task.
	 * @throws ResourceNotFoundException if the task with the given ID does not exist.
	 */
	
	@Override
	public Task editTask(Long taskId, Task updatedTask) throws ResourceNotFoundException, InvalidTaskException {
		// Check if the updatedTask is valid before proceeding with the edit
	    if (!isValidTask(updatedTask)) {
	        throw new InvalidTaskException("Invalid task data");
	    }

	    // Retrieve the task from the database
	    Optional<Task> optionalTask = taskRepository.findById(taskId);

	    if (optionalTask.isPresent()) {
	        Task existingTask = optionalTask.get();

	        // Update the task properties with the new values
	        existingTask.setTitle(updatedTask.getTitle());
	        existingTask.setDescription(updatedTask.getDescription());
	        existingTask.setStatus(updatedTask.getStatus());

	        // Save the updated task to the database
	        return taskRepository.save(existingTask);
	    } else {
	        // If the task doesn't exist, throw an exception
	        throw new ResourceNotFoundException("Task with ID " + taskId + " not found");
	    }
	}

	/**
	 * Deletes an existing task with the provided task ID.
	 *
	 * @param taskId of the task to delete.
	 * @return A message indicating the deletion was successful.
	 * @throws ResourceNotFoundException if the task with the given ID does not exist.
	 */
	
	@Override
	public String deleteTask(Long taskId) throws ResourceNotFoundException {
		
		// Retrieve the task from the database
	    Optional<Task> optionalTask = taskRepository.findById(taskId);

	    if (optionalTask.isPresent()) {
	        // Delete the task from the database
	        taskRepository.deleteById(taskId);
	        return "Task with ID " + taskId + " has been deleted";
	    } else {
	        // If the task doesn't exist, throw an exception
	        throw new ResourceNotFoundException("Task with ID " + taskId + " not found");
	    }
	}
	
	/**
     * Checks whether a task is valid by verifying that its title and description are not empty.
     *
     * @param task to validate.
     * @return {@code true} if the task is valid (title and description are not empty), {@code false} otherwise.
     */
	
	private boolean isValidTask(Task task) {
        // Check if the title and description fields are non-empty
        return !StringUtils.isEmpty(task.getTitle()) && !StringUtils.isEmpty(task.getDescription());
    }
	
	 /**
     * Retrieves a list of all tasks in the task tracker.
     *
     * @return A list of tasks.
     */

	@Override
	public List<Task> getAllTasks() {
		
		// Use the Spring Data JPA repository to retrieve all tasks from the database
        return taskRepository.findAll();
	}
	
	/**
     * Retrieves a specific task by its task ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @return The task with the specified ID.
     * @throws ResourceNotFoundException if the task with the given ID does not exist.
     */

	@Override
	public Task getTaskById(Long taskId) throws ResourceNotFoundException {
		
		// Use the Spring Data JPA repository to retrieve a task by its ID
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + taskId + " not found"));
	}

}
