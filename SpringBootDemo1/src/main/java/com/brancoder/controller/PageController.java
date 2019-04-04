package com.brancoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brancoder.service.IEmployeeManagementService;


@Controller
@RequestMapping("/page")
public class PageController {
	
	@Autowired
	private IEmployeeManagementService employeeService;
	
	@RequestMapping("/")
	public String index(ModelMap map) {
		// 加入一個屬性，供模板中讀取
		map.addAttribute("host", "http://www.brancoder.com");
		// return模板文件的名稱，對應resources/templates/temp.html
		return "index";
	}

	@RequestMapping("/employees")
	public String listEmployees(@RequestParam(value="title", required=false, defaultValue="brancoder") String title, Model model) {

		
		model.addAttribute("name", "Brandon");
		model.addAttribute("employees", employeeService.listEmployees());
		
		return "employees";
	}
}