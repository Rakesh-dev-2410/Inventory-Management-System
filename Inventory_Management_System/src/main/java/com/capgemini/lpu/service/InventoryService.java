package com.capgemini.lpu.service;

import java.util.Map;

import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.exceptions.InvalidOrderIdException;
import com.capgemini.lpu.exceptions.InvalidPriceException;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorException;
import com.capgemini.lpu.exceptions.OutofStockException;

public interface InventoryService {

	public boolean addOrder(Order order) throws InvalidOrderIdException, 
	   										   InvalidProductIdException, 
	   										   InvalidPriceException, 
	   										   InvalidVendorException, 
	   										   OutofStockException;         //adds the order to ordermap.
	
	public String orderIdGenerator();	//generates Random Order Id.
	public boolean checkRandomOrderId(String str); //checks for unique Order Id.
	public Map<String,Order> viewAllOrders(); 	//Displays all the orders placed.
}