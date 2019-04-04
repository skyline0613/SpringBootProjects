package com.brancoder.dao;

import java.util.List;

import com.brancoder.entity.Employee;

public interface IEmployeeDAO {
	
	public boolean insertEmployee(Employee employee);
	
	public List<Employee> listEmployees();
	
	public Employee getEmployee(String empno);
	
	public boolean updateEmployee(Employee employee);	
}
