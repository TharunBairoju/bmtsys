package com.bmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmtsys.command.member.EnroleMemberCommand;
import com.bmtsys.command.member.FetchAllMemberCommand;
import com.bmtsys.command.member.FetchMemberCommand;
import com.bmtsys.constants.BmtsysConstants;
import com.bmtsys.entity.Member;
import com.bmtsys.request.EnroleMember;
import com.bmtsys.response.ErrorResponse;
import com.bmtsys.response.MemberInfo;
import com.bmtsys.response.SuccessResponse;

/**
 * created on : Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

@RestController
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	EnroleMemberCommand enroleMemberCommand;
	
	@Autowired
	FetchMemberCommand fetchMemberCommand;
	
	@Autowired
	FetchAllMemberCommand fetchAllMemberCommand;
	

	@RequestMapping(value = "/enrole", method = RequestMethod.POST)
	public ResponseEntity<?> enrolMember(@RequestBody EnroleMember enroleMember) {
		Member member = enroleMemberCommand.excute(enroleMember);
		if (member != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, member));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while enrolement..!"));
	}
	
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public ResponseEntity<?> getMember(@RequestParam(name="memberId") Long memberId) {
		MemberInfo member = fetchMemberCommand.excute(memberId);
		if (member != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, member));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while fetching member..!"));
	}
	
	
	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMember() {
		List<Member> members = fetchAllMemberCommand.excute(null);
		if (members != null) {
			return ResponseEntity.status(200).body(new SuccessResponse(200, BmtsysConstants.SUCCESS, members));
		}
		return ResponseEntity.status(500).body(new ErrorResponse(500, "Something went wrong while fetching members..!"));
	}
	

}
