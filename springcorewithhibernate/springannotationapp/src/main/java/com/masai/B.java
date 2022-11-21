package com.masai;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class B {
	
	
	public void showB() {
		System.out.println("inside showB of B");
		
	}
	
	
	@Bean
	public Student getStudent() {
		Student student = new Student(10, "Ram", 780);
		return student;
		
	}
	
	
	

}
