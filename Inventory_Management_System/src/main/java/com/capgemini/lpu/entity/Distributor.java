package com.capgemini.lpu.entity;

public class Distributor {
	
	private String distId;
	private String distName;
	private String distCity;
	private String distPh;
	
	public Distributor(String distId, String distName, String distCity, String distPh) {
		super();
		this.distId = distId;
		this.distName = distName;
		this.distCity = distCity;
		this.distPh = distPh;
	}

	public String getDistId() {
		return distId;
	}

	public String getDistName() {
		return distName;
	}

	public String getDistCity() {
		return distCity;
	}

	public String getDistPh() {
		return distPh;
	}
	
	
	
}
