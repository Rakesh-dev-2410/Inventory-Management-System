package com.capgemini.lpu.exceptions;

public class InvalidOrderIdException extends Exception{
	
	public InvalidOrderIdException() {
		super();
	}
	
	public InvalidOrderIdException(String message) {
		super(message);
	}
}
