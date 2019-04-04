package com.brancoder.demo.ui.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.brancoder.demo.service.MemberService;
import com.brancoder.demo.ui.model.request.MemberDetailsRequestModel;
import com.brancoder.demo.ui.model.request.UpdateMemberDetailsRequestModel;
import com.brancoder.demo.ui.model.response.MemberRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	//Map<String, MemberRest> members = new HashMap<String, MemberRest>();
	Map<String, MemberRest> members;
	
	
	@Autowired
	MemberService memberService;	
	
	@GetMapping
	public String getMembers(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="10") int limit,
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort)
	{
		return "get users was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}
	
	@GetMapping(path="/{memberId}", 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					} )
	public ResponseEntity<MemberRest> getMember(@PathVariable String memberId)
	{
		if(members.containsKey(memberId))
		{
			return new ResponseEntity<>(members.get(memberId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	
	@PostMapping(
			consumes =  { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public ResponseEntity<MemberRest> createUser(@Valid @RequestBody MemberDetailsRequestModel memberDetails)
	{
		MemberRest returnValue = memberService.createMember(memberDetails);
		return new ResponseEntity<MemberRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(path="/{memberId}", consumes =  { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public MemberRest updateUser(@PathVariable String memberId, @Valid @RequestBody UpdateMemberDetailsRequestModel memberDetails)
	{
		MemberRest storedUserDetails = members.get(memberId);
		 storedUserDetails.setFirstName(memberDetails.getFirstName());
		 storedUserDetails.setLastName(memberDetails.getLastName());
		 
		 members.put(memberId, storedUserDetails);
		 
		 return storedUserDetails;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id)
	{
		members.remove(id);
		
		return ResponseEntity.noContent().build();
	}	
}
