package com.springbootproject.projectmanagementsystem.exceptions;

public class ProjectAlreadyExistsException extends RuntimeException {

	public ProjectAlreadyExistsException(String message) {
		super(message);
	}
	
}
