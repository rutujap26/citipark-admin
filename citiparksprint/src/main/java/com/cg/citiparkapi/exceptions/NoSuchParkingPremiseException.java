package com.cg.citiparkapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchParkingPremiseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchParkingPremiseException() {
		super();
	}
	public NoSuchParkingPremiseException(String errMsg) {
		super(errMsg);
	}
}
