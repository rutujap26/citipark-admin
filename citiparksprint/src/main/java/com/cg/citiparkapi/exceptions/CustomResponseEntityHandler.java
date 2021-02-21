package com.cg.citiparkapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * To handle duplicate parking premise exception
	 * @param ex 
	 * @param request
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<Object> handleDuplicateParkingPremiseException(DuplicateParkingPremiseException ex, WebRequest request){
		DuplicateParkingPremiseExceptionResponse duplicateParkingPremiseExceptionResponse = new DuplicateParkingPremiseExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(duplicateParkingPremiseExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * To handle No such parking premise exception
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<Object> handleNoSuchParkingPremiseException(NoSuchParkingPremiseException ex, WebRequest request){
		NoSuchParkingPremiseExceptionResponse noSuchParkingPremiseExceptionResponse = new NoSuchParkingPremiseExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(noSuchParkingPremiseExceptionResponse,HttpStatus.BAD_REQUEST);
	}

}
