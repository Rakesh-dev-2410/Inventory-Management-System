package com.capgemini.lpu.dao;

import java.util.Map;

import com.capgemini.lpu.entity.InvSupplier;
import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.entity.ProductStock;
import com.capgemini.lpu.exceptions.InvalidOrderIdException;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorIDException;

public interface InventoryDao {

	public  ProductStock getProduct(String pid) throws InvalidProductIdException;	//returns the product
	public boolean daoAddOrder(Order order) throws InvalidOrderIdException ;
	
	public void updateProductStock(ProductStock prod);			//updates stock after placing an order
	public Order getOrder(String ordID) throws InvalidOrderIdException;			//checks whether order id is present in orderlist or not. 
	public InvSupplier getVendor(String vendor) throws InvalidVendorIDException;		//used to validate vendor 
	public Map<String, Order> viewAllOrders();
}
