package com.bmtsys.response;

import java.io.Serializable;
import java.util.List;

import com.bmtsys.entity.Member;
import com.bmtsys.entity.Role;

/**
 * created on : Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public class MemberAssignedRoles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Member member;
	private List<Role> roles;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
