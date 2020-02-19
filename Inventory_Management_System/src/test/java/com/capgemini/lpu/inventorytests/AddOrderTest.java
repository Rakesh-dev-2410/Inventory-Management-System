package com.capgemini.lpu.inventorytests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

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
	@DisplayName("Test validation when Supplier ID is given incorrectly.")
	public void testAddOrder1() {
		assertThrows(InvalidVendorIDException.class, ()->ser.addOrder(new Order("F549",  900.0, 10, LocalDate.of(2020, 03, 21), "7ygj")));
	}
	
	@Test
	@DisplayName("Test validation when Supplier ID is given NULL.")
	public void testAddOrder2() {
		assertThrows(InvalidVendorIDException.class, ()->ser.addOrder(new Order("F549",  900.0, 10, LocalDate.of(2020, 03, 21), "")));
	}
	
	@Test
	@DisplayName("Test validation when Product ID is given incorrectly.")
	public void testAddOrder3() {
		assertThrows(InvalidProductIdException.class, ()->ser.addOrder(new Order("fv5G",  900.0, 10, LocalDate.of(2020, 03, 21), "1002")));
	}
	
	@Test
	@DisplayName("Test validation when Product ID is NULL.")
	public void testAddOrder4() {
		assertThrows(InvalidProductIdException.class, ()->ser.addOrder(new Order("",  900.0, 10, LocalDate.of(2020, 03, 21), "1002")));
	}
	
	@Test
	@DisplayName("Test validation when ordered quantity is greater than stock quantity.")
	public void testAddOrder5() {
		assertThrows(OutofStockException.class, ()->ser.addOrder(new Order("F549",  900.0, 1000, LocalDate.of(2020, 03, 21), "1002")));
	}
	
	@Test
	@DisplayName("Test validation when all the data is given correctly.")
	public void testAddOrder6() throws InvalidOrderIdException, InvalidProductIdException, InvalidVendorIDException, OutofStockException  {
		assertTrue(ser.addOrder(new Order("F549", 800.0, 108, LocalDate.of(2020, 01, 21), "1002")));
	}
}
