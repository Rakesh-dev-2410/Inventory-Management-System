package com.capgemini.lpu.inventorytests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.exceptions.InvalidOrderIdException;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorIDException;
import com.capgemini.lpu.exceptions.OutofStockException;
import com.capgemini.lpu.service.InventoryService;
import com.capgemini.lpu.service.InventoryServiceImpl;


public class AddOrderTest {
	public static InventoryService ser;
	
	@BeforeAll
	public static void beforeClass() {
		ser = new InventoryServiceImpl();
	}
	@Test
	@DisplayName("Test case 1 for addProduct")
	public void testAddOrder1() throws InvalidOrderIdException, InvalidProductIdException, InvalidVendorIDException, OutofStockException  {
		assertTrue(ser.addOrder(new Order("F549", 10, "1002")));
	}
	
	@Test
	@DisplayName("Test validation when Product ID is NULL.")
	public void testAddOrder2() {
		assertThrows(InvalidProductIdException.class, ()->ser.addOrder(new Order(null, 10, "1001")));
	}
	
	@Test
	@DisplayName("Test validation when Product ID is given incorrectly.")
	public void testAddOrder3() {
		assertThrows(InvalidProductIdException.class, ()->ser.addOrder(new Order("gh67", 10, "1001")));
	}
	
	@Test
	@DisplayName("Test validation when ordered quantity is greater than stock quantity.")
	public void testAddOrder4() {
		assertThrows(OutofStockException.class, ()->ser.addOrder(new Order("F549", 1000, "1002")));
	}
	
	@Test
	@DisplayName("Test validation when Supplier ID is given incorrectly.")
	public void testAddOrder5() {
		assertThrows(InvalidVendorIDException.class, ()->ser.addOrder(new Order("F549", 10, "12345")));
	}
	
	@Test
	@DisplayName("Test validation when Supplier ID is given NULL.")
	public void testAddOrder6() {
		assertThrows(InvalidVendorIDException.class, ()->ser.addOrder(new Order("F549", 10, null)));
	}
}
