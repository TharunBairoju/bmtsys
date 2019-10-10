package com.bmtsys.command.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Member;
import com.bmtsys.entity.MemberSessionDetails;
import com.bmtsys.entity.SessionStatus;
import com.bmtsys.repository.MemberRepository;
import com.bmtsys.service.MemberService;

/**
 * created on :  Oct 10, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class LogoutMemberCommand implements Command<Long, MemberSessionDetails>{
	
	@Autowired
	MemberRepository memberRepository; 
	
	@Autowired
	MemberService memberService;

	@Override
	public MemberSessionDetails excute(Long memberId) {
		try {
			Optional<Member> member = memberRepository.findById(memberId);
			MemberSessionDetails sessionDetails= memberService.updateMemberSessionDetails(member.get(), SessionStatus.LOGOUT.getStatus());
			memberService.updateMemberSessionHistory(member.get(), SessionStatus.LOGOUT.getStatus());
			return sessionDetails;
		}catch(Exception e) {
			
		}
		return null;
	}

}
