package com.TaskTracker.exceptions;

/**
 * Exception thrown when attempting to access a resource that doesn't exist.
 */

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
