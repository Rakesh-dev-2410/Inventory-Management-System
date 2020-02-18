package com.capgemini.lpu.dao;

import java.util.Map;
import com.capgemini.lpu.entity.InvSupplier;
import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.entity.ProductStock;
import com.capgemini.lpu.exceptions.InvalidOrderIdException;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorException;
import com.capgemini.lpu.repo.InventoryRepository;


public class InventoryDaoImpl implements InventoryDao {
	

	@Override
	public ProductStock getProduct(String pid) throws InvalidProductIdException {
		if(InventoryRepository.smap.containsKey(pid))
		      return InventoryRepository.smap.get(pid);
		throw new InvalidProductIdException();
	}

	@Override
	public boolean daoAddOrder(Order order) throws InvalidOrderIdException {
		if(!InventoryRepository.ordermap.containsKey(order.getOrderId())) {
			InventoryRepository.ordermap.put(order.getOrderId(),order);
			return true;
			}
		
			throw new InvalidOrderIdException();
			
	}

	@Override
	public Order getOrder(String ordID) throws InvalidOrderIdException {
		if(!InventoryRepository.ordermap.containsKey(ordID)) {
			return InventoryRepository.ordermap.get(ordID);
			}
		else
			throw new InvalidOrderIdException();
			
		
	}

	@Override
	public InvSupplier getVendor(String vendorID) throws InvalidVendorException {
		if(InventoryRepository.vendormap.containsKey(vendorID)) {
			return InventoryRepository.vendormap.get(vendorID);
		}
		else
			throw new InvalidVendorException();
	}


	@Override
	public void updateProductStock(String pid,int ordqty) {
		ProductStock prod = InventoryRepository.smap.get(pid);
		int qty = prod.getProdStockQty();
		prod.setProdStockQty(qty-ordqty);
		InventoryRepository.smap.remove(pid);
		InventoryRepository.smap.put(prod.getProdId(), prod);
	}

	@Override
	public Map<String, Order> viewAllOrders() {
		return InventoryRepository.ordermap;
	}

	
	
	

}
