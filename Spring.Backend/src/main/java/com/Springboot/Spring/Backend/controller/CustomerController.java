package com.Springboot.Spring.Backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Springboot.Spring.Backend.entity.Customer;
import com.Springboot.Spring.Backend.service.CustomerService;

import ExceptionHandling.ErrorResponse;



@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getCustomers();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
	{
		customerService.saveCustomer(customer);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/Customers/{id}")
	public String DeleteCustomer(@PathVariable Long id)
	{
		return customerService.deleteCustomer(id);
	}
	
	@GetMapping("/Customers/{id}")
	public Customer findCustomerById(@PathVariable Long id)
	{
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getCustomers/{name}")
	public Customer findCourseByName(@PathVariable String name)
	{
		return customerService.getCustomerByName(name);
	}
	
	

}
