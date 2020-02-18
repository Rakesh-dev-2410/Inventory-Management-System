package com.capgemini.lpu.dao;

import java.util.Map;
import com.capgemini.lpu.entity.InvSupplier;
import com.capgemini.lpu.entity.Order;
import com.capgemini.lpu.entity.ProductStock;
import com.capgemini.lpu.exceptions.InvalidOrderIdException;
import com.capgemini.lpu.exceptions.InvalidProductIdException;
import com.capgemini.lpu.exceptions.InvalidVendorIDException;
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
	public InvSupplier getVendor(String vendorID) throws InvalidVendorIDException {
		if(InventoryRepository.vendormap.containsKey(vendorID)) {
			return InventoryRepository.vendormap.get(vendorID);
		}
		else
			throw new InvalidVendorIDException();
	}

	@Override
	public Map<String, Order> viewAllOrders() {
		return InventoryRepository.ordermap;
	}

	@Override
	public void updateProductStock(ProductStock prod) {
		InventoryRepository.smap.put(prod.getProdId(), prod);
		
	}

	
	
	

}
