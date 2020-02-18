package com.capgemini.lpu.exceptions;

public class InvalidVendorException extends Exception {

	public InvalidVendorException() {
		System.err.println("Vendor Name NOT FOUND");
	}
}
