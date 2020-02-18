package com.capgemini.lpu.inventorytests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.exceptions.InvalidOrderIdException;
import com.capgemini.lpu.exceptions.InvalidPriceException;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorException;
import com.capgemini.lpu.exceptions.OutofStockException;
import com.capgemini.lpu.service.InventoryService;
import com.capgemini.lpu.service.InventoryServiceImpl;


public class InventoryMngmntSystemTest {
	InventoryService ser = new InventoryServiceImpl();

	@Test
	@DisplayName("Test case for addProduct")
	public void testAddOrder() throws InvalidOrderIdException, InvalidProductIdException, InvalidPriceException, InvalidVendorException, OutofStockException  {
		assertTrue(ser.addOrder(new Order("J342", 680.0, 10, LocalDate.of(2020, 03, 21), "1001")));
	}
}
