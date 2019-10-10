package com.bmtsys.command.role;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Role;
import com.bmtsys.repository.RoleRepository;
import com.bmtsys.request.ModifyRole;

/**
 * created on : Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class ModifyRoleCommand implements Command<ModifyRole, Role> {

	@Autowired
	RoleRepository roleRepository; 
	
	@Override
	public Role excute(ModifyRole request) {
		
		try {
			Optional<Role> role = roleRepository.findById(request.getId());
			if(role != null && role.get() != null) {
				Role updatedRole = modifyRoleObject(role.get(), request);
				roleRepository.save(updatedRole);
				return updatedRole;
			}
		}catch(Exception e) {
			
		}
		return null;
	}

	private Role modifyRoleObject(Role originalRole, ModifyRole request) {
		originalRole.setEnabled(request.isEnabled());
		originalRole.setRoleName(request.getRoleName());
		originalRole.setStatus(request.getStatus());
		return originalRole;
	}

}
