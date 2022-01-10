package com.Springboot.Spring.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Spring.Backend.entity.Customer;
import com.Springboot.Spring.Backend.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	
	public Customer saveCustomer(Customer customer) {
		
			return repository.save(customer);	
	}
	public List<Customer> getCustomers()
	{
		return repository.findAll();
	}
	public Customer getCustomerById(Long id)
	{
		return repository.findById(id).orElse(null);
	}
	public Customer getCustomerByName(String name)
	{
		return repository.findByName(name).orElse(null);
	}
	public String deleteCustomer(Long id)
	{
		repository.deleteById(id);
		return "removed"+id;
	}
	public Customer updateCustomer(Customer customer)
	{
		Customer s=repository.findById(customer.getId()).orElse(null);
		s.setName(customer.getName());
		return repository.save(s);	
	}
}
