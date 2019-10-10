package com.bmtsys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * created on : Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Entity
@Table(name = "MEMBER_ROLES")
public class MemberRoles extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Member.class)
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Role.class)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private Role role;
	
	@Column(name = "STATUS", nullable = false)
	private Status status;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
