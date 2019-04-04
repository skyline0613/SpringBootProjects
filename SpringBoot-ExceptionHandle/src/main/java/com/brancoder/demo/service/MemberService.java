package com.brancoder.demo.service;

import com.brancoder.demo.ui.model.request.MemberDetailsRequestModel;
import com.brancoder.demo.ui.model.response.MemberRest;

public interface MemberService {
	MemberRest createMember(MemberDetailsRequestModel userDetails);	
}
