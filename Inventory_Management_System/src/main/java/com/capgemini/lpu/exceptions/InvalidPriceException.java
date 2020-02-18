package com.capgemini.lpu.exceptions;

public class InvalidPriceException extends Exception{

	public InvalidPriceException() {
		System.err.println("Price is not valid");
	}
}
