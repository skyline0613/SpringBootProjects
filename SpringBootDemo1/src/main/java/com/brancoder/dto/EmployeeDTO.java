package com.brancoder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
public class EmployeeDTO{
	
	private String empId;
	
	private String empName;
	
	private String gender;

	
}
