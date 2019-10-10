package com.bmtsys.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.entity.Member;
import com.bmtsys.entity.MemberSessionDetails;
import com.bmtsys.entity.MemberSessionHistory;
import com.bmtsys.entity.SessionStatus;
import com.bmtsys.repository.MemberSessionDetailsRepository;
import com.bmtsys.repository.MemberSessionHistoryRepository;

/**
 * created on : Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class MemberService {

	@Autowired
	MemberSessionDetailsRepository memberSessionDetailsRepository;

	@Autowired
	MemberSessionHistoryRepository memberSessionHistoryRepository;

	/**
	 * 
	 * @param member
	 */
	public MemberSessionDetails updateMemberSessionDetails(Member member, String status) {
		MemberSessionDetails sessionDetails = null;
		try {
			sessionDetails = memberSessionDetailsRepository.findByMemberId(member.getId());
			if (sessionDetails != null) {
				sessionDetails.setSignInTLM(new Date());
				if(status.equals(SessionStatus.LOGOUT.getStatus())) {
					sessionDetails.setSignoutTLM(new Date());
				}
				sessionDetails.setStatus(status);
				memberSessionDetailsRepository.save(sessionDetails);
			} else {
				sessionDetails = new MemberSessionDetails();
				sessionDetails.setMember(member);
				sessionDetails.setSignInTLM(new Date());
				sessionDetails.setStatus(status);
				if(status.equals(SessionStatus.LOGOUT.getStatus())) {
					sessionDetails.setSignoutTLM(new Date());
				}
				memberSessionDetailsRepository.save(sessionDetails);
			}
			return sessionDetails;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 
	 * @param member
	 */
	public void updateMemberSessionHistory(Member member, String status) {
		try {
			MemberSessionHistory sessionHistory = new MemberSessionHistory();
			sessionHistory.setCreatedAt(new Date());
			sessionHistory.setMember(member);
			sessionHistory.setSessionStatus(status);
			memberSessionHistoryRepository.save(sessionHistory);
		} catch (Exception e) {

		}
	}

}
