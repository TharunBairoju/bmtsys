package com.bmtsys.request;

import java.util.List;

/**
 * created on : Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public class AssignRole {
	private long memberId;
	private List<Long> roleIds;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

}
