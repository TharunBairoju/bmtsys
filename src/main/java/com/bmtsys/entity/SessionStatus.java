package com.bmtsys.entity;

/**
 * created on :  Oct 10, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public enum SessionStatus {
	
	LOGIN("LOGIN"),LOGOUT("LOGOUT");
	
	private String status;
	
	SessionStatus(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
