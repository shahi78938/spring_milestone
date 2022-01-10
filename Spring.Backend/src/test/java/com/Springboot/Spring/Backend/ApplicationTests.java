package com.Springboot.Spring.Backend;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Springboot.Spring.Backend.entity.Customer;
import com.Springboot.Spring.Backend.repository.CustomerRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	CustomerRepository cRepo;
	
	@Test
	public void testCreate() {
		Customer c=new Customer();
		c.setId(2L);
		c.setName("poornima");
		c.setFoodPreference("veg");
		cRepo.save(c);
		assertNotNull(cRepo.findById(2L).get());
	}
	
	@Test
	public void testbyId()
	{
		Customer c = cRepo.findById(2L).get();
		assertEquals("poornima", c.getName());	
	}
	
	@Test
	public void testAll()
	{
		List<Customer> list = cRepo.findAll();
		assertTrue(list.size()>0);	
	}
	@Test
	public void testUpdate()
	{
		Customer e= cRepo.findById(2L).get();
		e.setName("geethika");
		cRepo.save(e);
		assertNotEquals("poornima",cRepo.findById(2L).get().getName());
	}

	@Test
	public void testDelete()
	{
		cRepo.deleteById(2L);
		assertFalse(cRepo.existsById(2L));
	}
}
