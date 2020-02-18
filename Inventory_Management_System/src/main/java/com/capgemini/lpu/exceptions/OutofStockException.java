package com.capgemini.lpu.exceptions;

public class OutofStockException extends Exception{

	public OutofStockException() {
		System.err.println("The selected product is OUT OF STOCK");
	}
}
 