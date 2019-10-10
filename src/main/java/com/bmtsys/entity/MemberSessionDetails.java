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
 * created on : Oct 10, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Entity
@Table(name = "MEMBER_SEESION_DETAILS")
public class MemberSessionDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class, optional = false)
	@JoinColumn(name = "MEMBER_ID", unique = true)
	private Member member;

	@Column(name = "SIGN_IN_TLM")
	private Date signInTLM;

	@Column(name = "SIGN_OUT_TLM")
	private Date signoutTLM;

	@Column(name = "SESSION_STATUS")
	private String status;

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

	public Date getSignInTLM() {
		return signInTLM;
	}

	public void setSignInTLM(Date signInTLM) {
		this.signInTLM = signInTLM;
	}

	public Date getSignoutTLM() {
		return signoutTLM;
	}

	public void setSignoutTLM(Date signoutTLM) {
		this.signoutTLM = signoutTLM;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
