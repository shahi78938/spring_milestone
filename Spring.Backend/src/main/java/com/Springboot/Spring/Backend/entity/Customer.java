package com.Springboot.Spring.Backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	private long id;
	private String name;
	private String FoodPreference;
	
	
	public Customer() {
		
	}
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public Customer(String name, String foodPreference) {
		super();
		this.name = name;
		FoodPreference = foodPreference;
	}
	public String getFoodPreference() {
		return FoodPreference;
	}
	public void setFoodPreference(String foodPreference) {
		FoodPreference = foodPreference;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
