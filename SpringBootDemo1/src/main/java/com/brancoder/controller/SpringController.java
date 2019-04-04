package com.brancoder.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brancoder.entity.Employee;

/**
 * @author Brandon 2017/8/14
 */
@RestController
@RequestMapping("/spring/")
public class SpringController {
	
	@RequestMapping("/")
	public String helloPage(){
		return "Hello! Spring Boot!";
	}
	
	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Hello! ";
	}

	@RequestMapping("/{name}/{age}")
	public @ResponseBody String showAge(@PathVariable("name") String name,@PathVariable("age") int age) {
		return "Hello " + name + "! You are "+age + " years old.";
	}

}
