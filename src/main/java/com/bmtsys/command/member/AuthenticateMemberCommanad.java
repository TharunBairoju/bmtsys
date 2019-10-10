package com.bmtsys.command.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Authentication;
import com.bmtsys.entity.Member;
import com.bmtsys.entity.MemberRoles;
import com.bmtsys.entity.SessionStatus;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.AuthenticationRepository;
import com.bmtsys.repository.MemberRepository;
import com.bmtsys.repository.MemberRolesRepository;
import com.bmtsys.request.MemberLogin;
import com.bmtsys.response.MemberInfo;
import com.bmtsys.service.MemberService;

/**
 * created on : Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class AuthenticateMemberCommanad implements Command<MemberLogin, MemberInfo> {

	@Autowired
	AuthenticationRepository authenticationRepository;

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberRolesRepository memberRolesRepository;
	
	@Autowired
	MemberService memberService;

	@Override
	public MemberInfo excute(MemberLogin memberLogin) {

		try {
			Authentication authentication = authenticationRepository.findByUserName(memberLogin.getUserName());
			if (authentication != null && authentication.getPassword().equals(memberLogin.getPassoword())) {
				Member member = memberRepository.findByAuthenticationId(authentication.getId());
				if (member != null) {
					MemberInfo memberInfo= new MemberInfo();
					memberInfo.setMember(member);
					List<MemberRoles> mroles= memberRolesRepository.findByMemberIdAndStatus(member.getId(), Status.ACTIVE);
					memberInfo.setRoles(mroles.stream().map(MemberRoles::getRole).collect(Collectors.toList()));
					memberService.updateMemberSessionDetails(member, SessionStatus.LOGIN.getStatus());
					memberService.updateMemberSessionHistory(member,SessionStatus.LOGIN.getStatus());
					return memberInfo;
				}
			}
		} catch (Exception e) {

		}
		return null;
	}
	
	
	
	

}
