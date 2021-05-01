package com.cg.onlineadvapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * This class is used to create user define exception
 * @author hvishwak
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AdvertiseIdException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AdvertiseIdException() {
		super();
	}
	
	public AdvertiseIdException(String errorMessage) {
		super(errorMessage);
	}
}
