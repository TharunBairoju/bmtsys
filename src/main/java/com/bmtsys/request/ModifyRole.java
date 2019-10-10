package com.bmtsys.request;

import com.bmtsys.entity.Status;

/**
 * created on :  Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public class ModifyRole {
	private long id;
	private String roleName;
	private Status status;
	private boolean isEnabled;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	

}
