package com.bmtsys.command.module;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Module;
import com.bmtsys.repository.ModuleRepository;
import com.bmtsys.request.ModifyModule;

/**
 * created on :  Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class ModifyModuleCommand implements Command<ModifyModule, Module>{

	@Autowired
	ModuleRepository moduleRepository; 
	
	@Override
	public Module excute(ModifyModule request) {
		try {
			Optional<Module> module = moduleRepository.findById(request.getId());
			if(module != null && module.get() != null) {
				Module updatedModule = setUpdatedPropsToModule(module.get(), request);
				moduleRepository.save(updatedModule);
				return updatedModule;
			}
		}catch(Exception e) {
			
		}
		return null;
	}

	private Module setUpdatedPropsToModule(Module module, ModifyModule request) {
		if(module.isEnabled() && !request.isEnabled()) {
			module.setEnabled(request.isEnabled());
		}
		if(request.getModuleName() != null) {
			module.setModuleName(request.getModuleName());	
		}
		if(request.getStatus() != null) {
			module.setStatus(request.getStatus());
		}
		return module;
	}

}
