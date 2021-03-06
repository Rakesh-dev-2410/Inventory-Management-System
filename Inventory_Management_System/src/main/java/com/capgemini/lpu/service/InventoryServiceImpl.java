package com.capgemini.lpu.service;

import java.util.Map;
import java.util.Random;

import com.capgemini.lpu.dao.InventoryDao;
import com.capgemini.lpu.dao.InventoryDaoImpl;
import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.entity.ProductStock;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorIDException;
import com.capgemini.lpu.exceptions.OutofStockException;

public class InventoryServiceImpl implements InventoryService {

	InventoryDao dao = new InventoryDaoImpl();
	
	@Override
	public boolean addOrder(Order order) throws InvalidProductIdException,InvalidVendorIDException, OutofStockException {
		
		if(!order.getvendorID().matches("[1][0-9]{3}") || order.getvendorID()==null)
			throw new InvalidVendorIDException("Invalid Supplier Id");		//validates Vendor ID.
		
		if( !order.getProdId().matches("[A-Z][0-9]{3}") || order.getProdId()==null)
			throw new InvalidProductIdException("Invalid Product Id");	//validates Product Id.
		
		ProductStock prod = dao.getProduct(order.getProdId());	
		if(order.getOrderQty()>prod.getProdStockQty())		//check the selected product is in the productStock or not.
			throw new OutofStockException("The selected product is out of stock");

		if(dao.daoAddOrder(order)) {
			String ordid=orderIdGenerator();
			order.setOrderId(ordid);
			ProductStock prod1 = dao.getProduct(order.getProdId());
			int stock = prod1.getProdStockQty()-order.getOrderQty();
			prod1.setProdStockQty(stock);
			dao.updateProductStock(prod1);
			return true;	 //Order placed Successfully
		}
		else
	     	return false; 	//Order is NOT placed.
	}

	@Override
	public String orderIdGenerator() {		//generates Random Id.
		
		Random rand = new Random();
		int num=0;
		String ordID = null;
		boolean flag = true;
		do {
			num = rand.nextInt(9999)+1000;
			String str = String.valueOf(num);
			String alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			StringBuilder sb = new StringBuilder();
			String temp = sb.append(alphabets.charAt(rand.nextInt(25))).toString();
			ordID = temp+str;
			
			if(!checkRandomOrderId(ordID))
				flag=false;
		}while(flag);
		return ordID;
	}

	@Override
	public boolean checkRandomOrderId(String str) {
		Map<String, Order> omap = dao.viewAllOrders();
		if(omap.containsKey(str)) {
			return false;
		}
			return true;
	}

	@Override
	public Map<String, Order> viewAllOrders() {		//gets all the orders placed.
		return dao.viewAllOrders();
	}

}
