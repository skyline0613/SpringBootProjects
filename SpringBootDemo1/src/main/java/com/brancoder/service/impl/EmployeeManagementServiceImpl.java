package com.brancoder.service.impl;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brancoder.dao.IEmployeeDAO;
import com.brancoder.dao.Impl.EmployeeDAOImpl;
import com.brancoder.entity.Employee;
import com.brancoder.service.IEmployeeManagementService;

@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {
	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	public List<Employee> listEmployees() {
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.listEmployees();
	}

}
