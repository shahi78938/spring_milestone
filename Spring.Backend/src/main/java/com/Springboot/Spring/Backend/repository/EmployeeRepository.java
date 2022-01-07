package com.Springboot.Spring.Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.Spring.Backend.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Optional<Employee> findByName(String name);

}
