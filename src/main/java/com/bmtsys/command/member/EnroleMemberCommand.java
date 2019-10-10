package com.bmtsys.command.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Authentication;
import com.bmtsys.entity.Member;
import com.bmtsys.entity.MemberStatus;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.AuthenticationRepository;
import com.bmtsys.repository.MemberRepository;
import com.bmtsys.request.EnroleMember;

/**
 * created on :  Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class EnroleMemberCommand implements Command<EnroleMember, Member>{
	
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	AuthenticationRepository authenticationRepository; 
	

	@Override
	public Member excute(EnroleMember request) {
		Authentication authentication = mapEnrolePropsToAddress(request);
		Member member = mapEnrolePropsToMember(request);
		try {
			authenticationRepository.save(authentication);
			member.setAuthentication(authentication);
			memberRepository.save(member);
			return member;
		}catch (Exception e) {
		}
		return null;
	}
	
	
	public Member mapEnrolePropsToMember(EnroleMember enroleMember) {
		Member member = new Member();
		member.setFirstName(enroleMember.getFirstName());
		member.setLastName(enroleMember.getLastName());
		member.setContactNumber(enroleMember.getContactNumber());
		member.setEnabled(true);
		member.setStatus(MemberStatus.ACTIVE);
		return member;
	}
	
	public Authentication mapEnrolePropsToAddress(EnroleMember enroleMember) {
		Authentication authentication = new Authentication();
		authentication.setUserName(enroleMember.getUserName());
		authentication.setPassword(enroleMember.getPassword());
		authentication.setStatus(Status.ACTIVE);
		authentication.setEnabled(true);
		return authentication;
	}

}
