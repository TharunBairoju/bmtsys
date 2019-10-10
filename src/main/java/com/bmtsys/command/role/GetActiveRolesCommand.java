package com.bmtsys.command.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Role;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.RoleRepository;

/**
 * created on :  Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class GetActiveRolesCommand implements Command<Long, List<Role>>{

	@Autowired
	RoleRepository roleRepository; 
	
	@Override
	public List<Role> excute(Long request) {
		try {
			List<Role> roles = roleRepository.findByStatus(Status.ACTIVE);
			if(roles != null) {
				return roles;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
