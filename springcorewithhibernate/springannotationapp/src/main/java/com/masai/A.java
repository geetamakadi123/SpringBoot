package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class A {

//	@Value("${id}")
//	private int id;
//	
//	@Value("${name}")
//	private String name;
//	
//	@Value("${salary}")
//	private int salary;
	

	@Autowired
	private Environment env;
	
	
	
	public void funA() {
		System.out.println("inside funA of A");
		
		System.out.println("Id is :"+env.getProperty("id"));
		System.out.println("Name is :"+env.getProperty("name"));
		System.out.println("Salary is :"+env.getProperty("salary"));
		
		
		
	}

}
