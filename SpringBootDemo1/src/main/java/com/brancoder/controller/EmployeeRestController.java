package com.brancoder.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brancoder.dto.EmployeeDTO;
import com.brancoder.entity.Employee;
import com.brancoder.service.IEmployeeManagementService;
import com.google.common.collect.Lists;

/**
 * @author Brandon 2017/8/14
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeManagementService employeeService;
	
	@RequestMapping("/{name}")
	public @ResponseBody String getName(@PathVariable("name") String name) {
		return "Hello <" + name +"> !";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<EmployeeDTO> listAll() {
		List<EmployeeDTO> list = Lists.newArrayList();
		Employee emp = new Employee();
		emp.setEmpId("FZ000530");
		list.add(backConvertFor(emp));
		return list;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeDTO getEmployee(@PathVariable("id") String id) {
		Employee emp = new Employee();
		
		return backConvertFor(emp);
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		System.out.println("addEmployee");
		return employeeDTO;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		System.out.println("updateEmployee");
		return employeeDTO;
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String removeEmployee(@PathVariable("id") String id) {
		System.out.println("removeEmployee");
		return "Delete";
	}
	private	Employee convertFor(EmployeeDTO employeeDTO){
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO,employee);
		return employee;
	}
	private	EmployeeDTO backConvertFor(Employee employee){
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee,employeeDTO);
		return employeeDTO;
	}	
}
