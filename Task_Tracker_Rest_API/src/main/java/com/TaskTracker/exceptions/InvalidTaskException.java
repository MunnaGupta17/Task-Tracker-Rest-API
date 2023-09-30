package com.TaskTracker.exceptions;


/**
 * Exception thrown when a task's data is invalid or doesn't meet certain criteria.
 */

public class InvalidTaskException extends RuntimeException{
	
	public InvalidTaskException(String message) {
		super(message);
	}

}
