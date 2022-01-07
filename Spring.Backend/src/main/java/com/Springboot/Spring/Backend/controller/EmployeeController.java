package com.Springboot.Spring.Backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Spring.Backend.entity.Employee;
import com.Springboot.Spring.Backend.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getEmployees();
	}

}
