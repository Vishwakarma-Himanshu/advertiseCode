package com.cg.onlineadvapi.serviceImpl;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationErrorService {

	/*
	 * This method is used to catch all errors which we saw in Advertise class
	 * It catches error while creating or updating advertise
	 */
	public ResponseEntity<?> mapValidationError(BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMessage = new HashMap<>();
			for(FieldError fieldError:result.getFieldErrors()) {
				errorMessage.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
