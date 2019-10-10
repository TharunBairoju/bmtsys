package com.bmtsys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmtsys.command.member.AuthenticateMemberCommanad;
import com.bmtsys.command.member.LogoutMemberCommand;
import com.bmtsys.constants.BmtsysConstants;
import com.bmtsys.entity.MemberSessionDetails;
import com.bmtsys.request.MemberLogin;
import com.bmtsys.response.ErrorResponse;
import com.bmtsys.response.MemberInfo;
import com.bmtsys.response.SuccessResponse;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticateMemberCommanad authenticateMemberCommanad; 
	
	@Autowired
	LogoutMemberCommand logoutMemberCommand;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<?> memberLogin(@RequestBody MemberLogin memberLogin, HttpSession session){
		MemberInfo member = authenticateMemberCommanad.excute(memberLogin);
		if (member != null) {
			session.setAttribute("memberInfo", member);
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, member));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Unable to login..!"));
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public ResponseEntity<?> memberLogout(@RequestParam("memberId") Long memberId, HttpSession session){
		MemberSessionDetails sessionDetails = logoutMemberCommand.excute(memberId);
		if (sessionDetails != null) {
			session.invalidate();
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, sessionDetails));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Unable to login..!"));

	}

}
