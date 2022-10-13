package com.technocrats.exceptions;

@SuppressWarnings("serial")
public class CustomerException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Number of units cannot be less than 0 | Entered customer details are invalid!";
	}

	
	
}
