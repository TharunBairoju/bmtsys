package com.bmtsys.entity;

/**
 * created on : Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public enum Status {
	
	ACTIVE("ACTIVE"), 
	INACTIVE("INACTIVE");
	
	private String status;
	
	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
