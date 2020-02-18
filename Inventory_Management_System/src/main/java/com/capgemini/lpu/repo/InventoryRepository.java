package com.capgemini.lpu.repo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.lpu.entity.InvSupplier;
import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.entity.ProductStock;

public class InventoryRepository {
	
	public static Map<String,InvSupplier> vendormap = new HashMap<>();
	public static Map<String, ProductStock> smap = new HashMap<>();
	public static Map<String,Order> ordermap =  new HashMap<>();
	
	static {
		
		/**
		 * Creating instances of suppliers and adding them to the list.
		 */
		InvSupplier sup1 = new InvSupplier("1001", "Sivaji Enterprises", "Banglore", "9781989995");
		InvSupplier sup2 = new InvSupplier("1002", "Surya Enterprises", "Hyderabad", "9384857383");
		
		vendormap.put(sup1.getSupId(), sup1);
		vendormap.put(sup2.getSupId(), sup2);
		
	
	/**
	 * The below block contains different types of products each supplier supplies.
	 */
	
		ProductStock prod1 = new ProductStock("A784", "Iron Bars", 1000, 500.0,"OK Tested",LocalDate.of(2016, 11, 12),sup1);
		ProductStock prod2 = new ProductStock("V114", "Steel Sheets", 1000, 1000.0,"OK Tested",LocalDate.of(2018, 12, 18),sup1);
		ProductStock prod3 =  new ProductStock("J983", "Aluminium Rolls", 250, 2500.0,"OK Tested",LocalDate.of(2017, 03, 26),sup1);
		ProductStock prod4 =  new ProductStock("J679", "Chairs", 1000, 230.0,"OK Tested",LocalDate.of(2012, 05, 18),sup1);
		ProductStock prod5 =  new ProductStock("R098", "Paints", 670, 790.0,"OK Tested",LocalDate.of(2017, 02, 14),sup1);
		ProductStock prod6 =  new ProductStock("I567", "Electric Boards", 10000, 200.0,"OK Tested",LocalDate.of(2018, 05, 24),sup1);
		ProductStock prod7 =  new ProductStock("U225", "Electric Wires", 1000, 1000.0,"OK Tested",LocalDate.of(2017, 03, 22),sup1);
		ProductStock prod8 =  new ProductStock("J873", "PVC Pipes", 7000, 940.0,"OK Tested",LocalDate.of(2018, 01, 12),sup1);
		
		ProductStock prod9 =  new ProductStock("J894", "Cement", 1000, 450.0,"OK Tested",LocalDate.of(2018, 01, 12),sup2);
		ProductStock prod10 =  new ProductStock("G257", "Plaster of Paris", 1000, 1500.0,"OK Tested",LocalDate.of(2018, 05, 12),sup2);
		ProductStock prod11 =  new ProductStock("R746", "Steel Sheets", 500, 970.0,"OK Tested",LocalDate.of(2018, 03, 23),sup2);
		ProductStock prod12 =  new ProductStock("F549", "Motors", 750, 900.0,"OK Tested",LocalDate.of(2016, 01, 18),sup2);
		ProductStock prod13 =  new ProductStock("L209", "Chairs", 1200, 310.0,"OK Tested",LocalDate.of(2019, 06, 11),sup2);
		ProductStock prod14 =  new ProductStock("E782", "Paints", 780, 900.0,"OK Tested",LocalDate.of(2017, 04, 12),sup2);
		ProductStock prod15 =  new ProductStock("Z126", "Electric Wires", 1450, 1100.0,"OK Tested",LocalDate.of(2017, 02, 27),sup2);
		ProductStock prod16 =  new ProductStock("N736", "Generators", 20, 50000.0,"OK Tested",LocalDate.of(2012, 01, 15),sup2);
		
		smap.put(prod1.getProdId(), prod1);
		smap.put(prod2.getProdId(), prod2);
		smap.put(prod3.getProdId(), prod3);
		smap.put(prod4.getProdId(), prod4);
		smap.put(prod5.getProdId(), prod5);
		smap.put(prod6.getProdId(), prod6);
		smap.put(prod7.getProdId(), prod7);
		smap.put(prod8.getProdId(), prod8);
		smap.put(prod9.getProdId(), prod9);
		smap.put(prod10.getProdId(), prod10);
		smap.put(prod11.getProdId(), prod11);
		smap.put(prod12.getProdId(), prod12);
		smap.put(prod13.getProdId(), prod13);
		smap.put(prod14.getProdId(), prod14);
		smap.put(prod15.getProdId(), prod15);
		smap.put(prod16.getProdId(), prod16);
		
		/*
		 * The below block contains the Orders
		 */
		
		Order ord1 = new Order("A1002", "V114", 1000.0, 200, LocalDate.of(2020, 3, 12),"1001");
		Order ord2 = new Order("A1004", "G257", 1200.0, 100, LocalDate.of(2020, 5, 25),"1002");
		Order ord3 = new Order("A1006", "J679", 940.0, 20, LocalDate.of(2020, 4, 20),"1001");
		Order ord4 = new Order("A1008", "F549", 900.0, 10, LocalDate.of(2020, 3, 21),"1002");
		
		ordermap.put(ord1.getOrderId(), ord1);
		ordermap.put(ord2.getOrderId(), ord2);
		ordermap.put(ord3.getOrderId(), ord3);
		ordermap.put(ord4.getOrderId(), ord4);
		}
		
		
}


	
