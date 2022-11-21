package com.masai;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller(value = "isuc")
public class InsertStudentUseCase {
	
	@Autowired
	private StudentService sService;
	
	
	public void insertStudent() {
	
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Name ");
		String name= sc.next();
	
		System.out.println("Enter Marks ");
		int marks= sc.nextInt();
	
		
		Student student = new Student();
		student.setName(name);
		student.setMarks(marks);
		
		
	 	String result= sService.saveStudent(student);
		
	 	System.out.println(result);
	
	}
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		 InsertStudentUseCase obj= ctx.getBean("isuc",InsertStudentUseCase.class);
		
		 obj.insertStudent();
		
	}
	
	
}
