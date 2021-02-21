package com.cg.citiparkapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class DuplicateParkingPremiseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor for Duplicate parking premise exception
	 */
	public DuplicateParkingPremiseException() {
		super();
	}
	 /**
	  * Constructor with string error message.
	  * Duplicate Parking premise exception will pass error message to super class.
	  * @param errMsg
	  */
	public DuplicateParkingPremiseException(String errMsg) {
		super(errMsg);
	}
}
