package com.capgemini.lpu.exceptions;

public class InvalidVendorIDException extends Exception {

	public InvalidVendorIDException() {
		super();
	}
	
	public InvalidVendorIDException(String message) {
		super(message);
	}
}
