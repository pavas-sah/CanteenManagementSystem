package com.org.canteen.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.org.canteen.api.common.Gender;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue
	Integer id;
	String name;
	int age;
	Gender gender;
	
	public Customer() {
	}
	public Customer(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	
}
