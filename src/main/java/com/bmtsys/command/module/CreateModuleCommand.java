package com.bmtsys.command.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Module;
import com.bmtsys.entity.Status;
import com.bmtsys.repository.ModuleRepository;

/**
 * created on : Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class CreateModuleCommand implements Command<Module, Module> {

	@Autowired
	ModuleRepository moduleRepository;

	@Override
	public Module excute(Module request) {
		try {
			request.setEnabled(true);
			request.setStatus(Status.ACTIVE);
			moduleRepository.save(request);
			return request;
		} catch (Exception e) {

		}
		return null;
	}

}
