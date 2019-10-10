package com.bmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmtsys.command.role.AssignRoleCommand;
import com.bmtsys.command.role.CreateRoleCommand;
import com.bmtsys.command.role.DisableAssignedRolesCommand;
import com.bmtsys.command.role.GetActiveRolesCommand;
import com.bmtsys.command.role.ModifyRoleCommand;
import com.bmtsys.constants.BmtsysConstants;
import com.bmtsys.entity.Role;
import com.bmtsys.request.AssignRole;
import com.bmtsys.request.DisableRoles;
import com.bmtsys.request.ModifyRole;
import com.bmtsys.response.ErrorResponse;
import com.bmtsys.response.MemberAssignedRoles;
import com.bmtsys.response.SuccessResponse;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@RestController
@RequestMapping(value="/role")
public class RoleController {
	
	@Autowired
	CreateRoleCommand createRoleCommand; 
	
	@Autowired
	ModifyRoleCommand modifyRoleCommand; 
	
	@Autowired
	AssignRoleCommand assignRoleCommand;
	
	@Autowired
	DisableAssignedRolesCommand disableAssignedRolesCommand;
	
	@Autowired
	GetActiveRolesCommand getActiveRolesCommand;
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createRole(@RequestBody Role role){
		Role insertedrole = createRoleCommand.excute(role);
		if (insertedrole != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, insertedrole));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while creating role..!"));
	}
	
	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllRoles(){
		List<Role> activeRoles = getActiveRolesCommand.excute(null);
		if (activeRoles != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, activeRoles));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while fetching all roles..!"));
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public ResponseEntity<?> modifyRole(@RequestBody ModifyRole role){
		Role updatedRole = modifyRoleCommand.excute(role);
		if (updatedRole != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, updatedRole));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while modifying role..!"));
	}
	
	
	@RequestMapping(value = "/assign", method = RequestMethod.POST)
	public ResponseEntity<?> assignRole(@RequestBody AssignRole assignRole){
		MemberAssignedRoles assignedRoles = assignRoleCommand.excute(assignRole);
		if (assignedRoles != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, assignedRoles));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Unable to assign roles..!"));
	}
	
	@RequestMapping(value = "/disable", method = RequestMethod.PUT)
	public ResponseEntity<?> disableRoles(@RequestBody DisableRoles disableRole){
		MemberAssignedRoles assignedRoles = disableAssignedRolesCommand.excute(disableRole);
		if (assignedRoles != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, assignedRoles));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while disable role..!"));
	}
	
}
