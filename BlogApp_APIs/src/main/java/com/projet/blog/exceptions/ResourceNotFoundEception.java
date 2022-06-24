package com.projet.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundEception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	long fieldValue;

	public ResourceNotFoundEception(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
}
