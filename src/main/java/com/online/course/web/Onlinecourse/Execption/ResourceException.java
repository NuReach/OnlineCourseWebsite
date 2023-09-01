package com.online.course.web.Onlinecourse.Execption;

import org.springframework.http.HttpStatus;

public class ResourceException extends ApiException{
	public ResourceException(String resourceName, Long id) {
		super(HttpStatus.CONFLICT, String.format("%s with id %d ",resourceName,id ));
	}

}
