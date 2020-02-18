package com.capgemini.lpu.entity;

import java.time.LocalDate;

public class Order {
	
	private String orderId;
	private String prodId;
	private double price;
	private int orderQty;
	private LocalDate expDelDate;
	private String vendorID;
	
	public Order(String orderId, String prodId, double price, int orderQty, LocalDate expDelDate, String vendorID) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
		this.price = price;
		this.orderQty = orderQty;
		this.expDelDate = expDelDate;
		this.vendorID = vendorID;
	}
	

	public Order(String prodId, double price, int orderQty, LocalDate expDelDate, String vendorID) {
		super();
		this.prodId = prodId;
		this.price = price;
		this.orderQty = orderQty;
		this.expDelDate = expDelDate;
		this.vendorID = vendorID;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getProdId() {
		return prodId;
	}

	public double getPrice() {
		return price;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public LocalDate getExpDelDate() {
		return expDelDate;
	}

	public String getvendorID() {
		return vendorID;
	}
	
	
	
	
}
