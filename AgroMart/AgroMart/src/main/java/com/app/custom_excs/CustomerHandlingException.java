package com.app.custom_excs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class CustomerHandlingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerHandlingException(String errMesg) {
		super(errMesg);
	}

	
}
