package com.bmtsys.command.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtsys.command.Command;
import com.bmtsys.entity.Member;
import com.bmtsys.repository.MemberRepository;

/**
 * created on :  Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Service
public class FetchAllMemberCommand implements Command<Long, List<Member>>{
	
	@Autowired
	MemberRepository memberRepository;
	

	@Override
	public List<Member> excute(Long request) {
		try {
			return memberRepository.findAll();
		}catch(Exception e) {
			
		}
		return null;
	}

}
