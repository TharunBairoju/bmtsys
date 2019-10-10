package com.bmtsys.command.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Module;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.ModuleRepository;

/**
 * created on :  Oct 9, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class GetAllActiveModulesCommand implements Command<Long, List<Module>>{

	@Autowired
	ModuleRepository moduleRepository;
	
	@Override
	public List<Module> excute(Long request) {
		try {
			List<Module> modules= moduleRepository.findByStatus(Status.ACTIVE);
			if(modules != null) {
				return modules;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
