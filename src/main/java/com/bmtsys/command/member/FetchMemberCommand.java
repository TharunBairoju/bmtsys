package com.bmtsys.command.member;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Member;
import com.bmtsys.entity.MemberRoles;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.MemberRepository;
import com.bmtsys.repository.MemberRolesRepository;
import com.bmtsys.response.MemberInfo;

/**
 * created on : Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

@Service
public class FetchMemberCommand implements Command<Long, MemberInfo> {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberRolesRepository memberRolesRepository; 

	@Override
	public MemberInfo excute(Long memberId) {
		try {
			Optional<Member> optMemner = memberRepository.findById(memberId);
			if (optMemner != null) {
				MemberInfo memberInfo= new MemberInfo();
				memberInfo.setMember(optMemner.get());
				List<MemberRoles> mroles= memberRolesRepository.findByMemberIdAndStatus(optMemner.get().getId(), Status.ACTIVE);
				memberInfo.setRoles(mroles.stream().map(MemberRoles::getRole).collect(Collectors.toList()));
				return memberInfo;
			}
		} catch (Exception e) {
		}
		return null;
	}

}
