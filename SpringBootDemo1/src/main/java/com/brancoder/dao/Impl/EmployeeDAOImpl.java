package com.brancoder.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.brancoder.dao.IEmployeeDAO;
import com.brancoder.entity.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> listEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setEmpId("FZ000520");
		employee.setEmpName("員工一");
		employee.setGender("M");
		list.add(employee);
		employee = new Employee();
		employee.setEmpId("FZ000521");
		employee.setEmpName("員工二");
		employee.setGender("F");
		list.add(employee);		
		return list;
	}

	@Override
	public Employee getEmployee(String empId) {
		
		Employee employee = new Employee();
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
