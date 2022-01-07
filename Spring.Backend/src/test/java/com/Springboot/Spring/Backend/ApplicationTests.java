package com.Springboot.Spring.Backend;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Springboot.Spring.Backend.entity.Employee;
import com.Springboot.Spring.Backend.repository.EmployeeRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	EmployeeRepository eRepo;
	
	@Test
	public void testCreate() {
		Employee e=new Employee();
		e.setId(2L);
		e.setName("poornima");
		eRepo.save(e);
		assertNotNull(eRepo.findById(2L).get());
	}
	
	@Test
	public void testbyId()
	{
		Employee e = eRepo.findById(2L).get();
		assertEquals("poornima", e.getName());	
	}
	
	@Test
	public void testAll()
	{
		List<Employee> list = eRepo.findAll();
		assertTrue(list.size()>0);	
	}
	@Test
	public void testUpdate()
	{
		Employee e= eRepo.findById(2L).get();
		e.setName("geethika");
		eRepo.save(e);
		assertNotEquals("poornima",eRepo.findById(2L).get().getName());
	}

	@Test
	public void testDelete()
	{
		eRepo.deleteById(2L);
		assertFalse(eRepo.existsById(2L));
	}
}
