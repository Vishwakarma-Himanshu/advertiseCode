package com.cg.onlineadvapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class is used to catch exception throughout the program
 * @author hvishwak
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleAdvertiseIdException(AdvertiseIdException ex, WebRequest request){
		AdvertiseIdExceptionResponse advertiseIdExceptionResponse = new AdvertiseIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(advertiseIdExceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleNoAdvertiseException(NoAdvertiseException ex, WebRequest request){
		NoAdvertiseExceptionResponse noAdvertiseExceptionResponse = new NoAdvertiseExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(noAdvertiseExceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
