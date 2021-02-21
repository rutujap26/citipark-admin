package com.cg.citiparkapi.exceptions;

public class DuplicateParkingPremiseExceptionResponse {

	private String premiseIdentifier;

	public DuplicateParkingPremiseExceptionResponse(String premiseIdentifier) {
		super();
		this.premiseIdentifier = premiseIdentifier;
	}

	public String getPremiseIdentifier() {
		return premiseIdentifier;
	}

	public void setPremiseIdentifier(String premiseIdentifier) {
		this.premiseIdentifier = premiseIdentifier;
	}
	
	
}
