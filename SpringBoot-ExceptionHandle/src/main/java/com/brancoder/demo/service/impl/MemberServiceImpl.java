package com.brancoder.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brancoder.demo.service.MemberService;
import com.brancoder.demo.ui.model.request.MemberDetailsRequestModel;
import com.brancoder.demo.ui.model.response.MemberRest;

@Service
public class MemberServiceImpl implements MemberService {

	
	Map<String, MemberRest> members;
	

	
	@Autowired
	public MemberServiceImpl() 
	{

	}
	
	@Override
	public MemberRest createMember(MemberDetailsRequestModel memberDetails) {
		MemberRest returnValue = new MemberRest();
		returnValue.setEmail(memberDetails.getEmail());
		returnValue.setFirstName(memberDetails.getFirstName());
		returnValue.setLastName(memberDetails.getLastName());
		returnValue.setMemberId(java.util.UUID.randomUUID().toString());
		
		if(members == null) 
			members = new HashMap<>();
		
		members.put(returnValue.getMemberId(), returnValue);
		
		return returnValue;
	}

}
