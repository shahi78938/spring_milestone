package com.Springboot.Spring.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Spring.Backend.entity.Employee;
import com.Springboot.Spring.Backend.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	
	public Employee saveEmployee(Employee employee) {
		
			return repository.save(employee);	
	}
	public List<Employee> getEmployees()
	{
		return repository.findAll();
	}
	public Employee getEmployeeById(Long id)
	{
		return repository.findById(id).orElse(null);
	}
	public Employee getEmployeeByName(String name)
	{
		return repository.findByName(name).orElse(null);
	}
	public String deleteEmployee(Long id)
	{
		repository.deleteById(id);
		return "removed"+id;
	}
	public Employee updateEmployee(Employee employee)
	{
		Employee s=repository.findById(employee.getId()).orElse(null);
		s.setName(employee.getName());
		return repository.save(s);	
	}
}
