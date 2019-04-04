package com.brancoder.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Accessors(chain = true)
@Setter
@Getter
@Data
public class Employee {
	
	private String empId;
	
	private String empName;
	
	private String gender;
	
	private String password;
	
	private String deptId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	
}
