package com.capgemini.lpu.entity;

public class InvSupplier {
	
	private String supId;
	private String supName;
	private String supCity;
	private String supPh;
	
	public InvSupplier(String supId, String supName, String supCity, String supPh) {
		super();
		this.supId = supId;
		this.supName = supName;
		this.supCity = supCity;
		this.supPh = supPh;
	}

	public String getSupId() {
		return supId;
	}

	public String getSupName() {
		return supName;
	}

	public String getSupCity() {
		return supCity;
	}

	public String getSupPh() {
		return supPh;
	}
	
	
	
}
