package com.bmtsys.command.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Role;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.RoleRepository;

/**
 * created on :  Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class CreateRoleCommand implements Command<Role, Role>{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role excute(Role request) {
		try {
			request.setEnabled(true);
			request.setStatus(Status.ACTIVE);
			roleRepository.save(request);
			return request;
		}catch(Exception e) {
			
		}
		return null;
	}
}
