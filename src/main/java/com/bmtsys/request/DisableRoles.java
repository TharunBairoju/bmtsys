package com.bmtsys.request;

import java.util.List;

/**
 * created on : Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public class DisableRoles {

	private long memberId;
	private List<Long> memberRoleIds;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public List<Long> getMemberRoleIds() {
		return memberRoleIds;
	}

	public void setMemberRoleIds(List<Long> memberRoleIds) {
		this.memberRoleIds = memberRoleIds;
	}

}
