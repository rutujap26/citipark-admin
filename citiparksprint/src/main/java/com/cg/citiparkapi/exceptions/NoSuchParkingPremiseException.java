package com.cg.citiparkapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchParkingPremiseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for No such parking premise exception.
	 */
	public NoSuchParkingPremiseException() {
		super();
	}
	
	/**
	 * Constructor with string error message.
	 * No such parking premise exception will pass error messege to super class.
	 * @param errMsg
	 */
	public NoSuchParkingPremiseException(String errMsg) {
		super(errMsg);
	}
}
