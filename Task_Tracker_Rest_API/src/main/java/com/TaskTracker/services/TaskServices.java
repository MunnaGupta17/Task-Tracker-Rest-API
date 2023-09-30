package com.TaskTracker.services;

import java.util.List;

import com.TaskTracker.exceptions.InvalidTaskException;
import com.TaskTracker.exceptions.ResourceNotFoundException;
import com.TaskTracker.models.Task;

public interface TaskServices {
	
	/**
     * Adds a new task to the task tracker.
     *
     * @param task to add new task in database.
     * @return The added task.
     */
	public Task addTask(Task task)throws InvalidTaskException;
	
	/**
     * Edits an existing task with the provided task ID.
     *
     * @param taskId of the task to edit.
     * @param updatedTask to updated task data.
     * @return The edited task.
     * @throws ResourceNotFoundException if the task with the given ID does not exist.
     * @throws InvalidTaskException     if the updated task data is invalid.
     */
	
	public Task editTask(Long taskId,Task updatedTask)throws ResourceNotFoundException,InvalidTaskException;
	
	/**
     * Deletes an existing task with the provided task ID.
     *
     * @param taskId of the task to delete.
     * @return A message indicating the deletion was successful.
     * @throws ResourceNotFoundException if the task with the given ID does not exist.
     */
	
	public String deleteTask(Long taskId)throws ResourceNotFoundException;
	
	 /**
     * Retrieves a list of all tasks in the task tracker.
     *
     * @return A list of tasks.
     */
	
	public List<Task> getAllTasks();
	
	/**
     * Retrieves a specific task by its task ID.
     *
     * @param taskId of the task to retrieve.
     * @return The task with the specified ID.
     * @throws ResourceNotFoundException if the task with the given ID does not exist.
     */
	public Task getTaskById(Long taskId)throws ResourceNotFoundException;

}
