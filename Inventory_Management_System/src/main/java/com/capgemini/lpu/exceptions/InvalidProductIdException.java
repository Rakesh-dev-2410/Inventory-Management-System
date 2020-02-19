package com.capgemini.lpu.exceptions;

public class InvalidProductIdException extends Exception {

	public InvalidProductIdException() {
		super();
	}
	
	public InvalidProductIdException(String message){
		super(message);
	}
	
}
