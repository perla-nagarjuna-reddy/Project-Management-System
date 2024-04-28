package com.springbootproject.projectmanagementsystem.exceptions;

import lombok.experimental.SuperBuilder;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
