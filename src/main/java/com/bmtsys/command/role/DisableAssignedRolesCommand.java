package com.bmtsys.command.role;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Member;
import com.bmtsys.entity.MemberRoles;
import com.bmtsys.entity.Role;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.MemberRepository;
import com.bmtsys.repository.MemberRolesRepository;
import com.bmtsys.repository.RoleRepository;
import com.bmtsys.request.DisableRoles;
import com.bmtsys.response.MemberAssignedRoles;


/**
 * created on :  Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class DisableAssignedRolesCommand implements Command<DisableRoles, MemberAssignedRoles>{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberRolesRepository memberRolesRepository; 
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public MemberAssignedRoles excute(DisableRoles request) {
		try {
			Optional<Member> member = memberRepository.findById(request.getMemberId());
			if(member.get() != null) {
				List<MemberRoles> droles = memberRolesRepository.findByIdIn(request.getMemberRoleIds());
				droles = disableMemberRoles(droles);
				if(droles != null) {
					List<MemberRoles> aroles = memberRolesRepository.findByMemberIdAndStatus(member.get().getId(), Status.ACTIVE);
					List<Role> roles = aroles.stream().map(MemberRoles::getRole).collect(Collectors.toList());
					MemberAssignedRoles assingedRoles = new MemberAssignedRoles();
					assingedRoles.setMember(member.get());
					assingedRoles.setRoles(roles);
					return assingedRoles;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	private List<MemberRoles> disableMemberRoles(List<MemberRoles> mroles) {
		try {
			for (MemberRoles memberRoles : mroles) {
				memberRoles.setActive(false);
				memberRoles.setStatus(Status.INACTIVE);
				memberRolesRepository.save(memberRoles);
			}
			return mroles;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	

}
