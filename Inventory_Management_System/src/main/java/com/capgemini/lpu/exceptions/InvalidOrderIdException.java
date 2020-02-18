package com.capgemini.lpu.exceptions;

public class InvalidOrderIdException extends Exception{

	public InvalidOrderIdException() {
		System.err.println("Invalid Order ID");
	}
}
