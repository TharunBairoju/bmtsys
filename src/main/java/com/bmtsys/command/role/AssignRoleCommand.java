package com.bmtsys.command.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.bmtsys.request.AssignRole;
import com.bmtsys.response.MemberAssignedRoles;

/**
 * created on :  Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class AssignRoleCommand implements Command<AssignRole, MemberAssignedRoles>{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberRolesRepository memberRolesRepository; 
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public MemberAssignedRoles excute(AssignRole request) {
		try {
			Optional<Member> member = memberRepository.findById(request.getMemberId());
			if(member.get() != null) {
				List<Role> roles = roleRepository.findByIdIn(request.getRoleIds());
				List<MemberRoles> mroles = assignRolesToMember(member.get(), roles);
				if(mroles != null) {
					MemberAssignedRoles memberAssignedRoles = new MemberAssignedRoles();
					memberAssignedRoles.setMember(member.get());
					memberAssignedRoles.setRoles(roles);
					return memberAssignedRoles;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param member
	 * @param roles
	 * @return
	 */
	private List<MemberRoles> assignRolesToMember(Member member, List<Role> roles) {
		try {
			List<MemberRoles> mroles = new ArrayList<MemberRoles>();
			for (Role role : roles) {
				MemberRoles memberRole = new MemberRoles();
				memberRole.setActive(true);
				memberRole.setMember(member);
				memberRole.setRole(role);
				memberRole.setStatus(Status.ACTIVE);
				memberRolesRepository.save(memberRole);
				mroles.add(memberRole);
			}
			return mroles;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
