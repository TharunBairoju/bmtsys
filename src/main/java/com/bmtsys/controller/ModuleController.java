package com.bmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmtsys.command.module.CreateModuleCommand;
import com.bmtsys.command.module.GetAllActiveModulesCommand;
import com.bmtsys.command.module.ModifyModuleCommand;
import com.bmtsys.constants.BmtsysConstants;
import com.bmtsys.entity.Module;
import com.bmtsys.request.ModifyModule;
import com.bmtsys.response.ErrorResponse;
import com.bmtsys.response.SuccessResponse;

/**
 * created on : Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@RestController
@RequestMapping(value = "/module")
public class ModuleController {
	
	@Autowired
	CreateModuleCommand createModuleCommand;

	@Autowired
	ModifyModuleCommand modifyModuleCommand;
	
	@Autowired
	GetAllActiveModulesCommand getAllActiveModulesCommand;
	
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> createModule(@RequestBody Module module) {
		Module insertedModule = createModuleCommand.excute(module);
		if (insertedModule != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, insertedModule));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while creating module..!"));
	}

	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public ResponseEntity<?> modifyRole(@RequestBody ModifyModule module) {
		Module updatedModule = modifyModuleCommand.excute(module);
		if (updatedModule != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, updatedModule));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while creating module..!"));
	}
	
	
	@RequestMapping(value = "/fetchAll", method = RequestMethod.PUT)
	public ResponseEntity<?> getAllActiveModules() {
		List<Module> activeModules = getAllActiveModulesCommand.excute(null);
		if (activeModules != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, activeModules));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while creating module..!"));
	}
	
	

}
