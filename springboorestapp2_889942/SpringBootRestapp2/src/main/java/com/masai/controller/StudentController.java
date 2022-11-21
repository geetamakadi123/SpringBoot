package com.masai.controller;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;

@RestController
public class StudentController {

	
	private List<Student> students= new ArrayList<>();
	
	public StudentController() {
		
		students.add(new Student(10, "Ram", 800));
		students.add(new Student(12, "Amit", 820));
		students.add(new Student(14, "Ravi", 840));
		students.add(new Student(16, "Rajeev", 850));
		students.add(new Student(18, "Vinay", 860));
		
	}
	
	
	@GetMapping("/students")
	public List<Student> getAllStudentDetailsHandler(){
		
		return students;
		
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll") Integer roll) {
		
		List<Student> list= students.stream().filter(s -> s.getRoll() == roll).collect(Collectors.toList());
		
		if(list.size() == 0)
			throw new IllegalArgumentException("Student does not exist with Roll "+roll);
		
		//return list.get(0);
		
		HttpHeaders hh = new  HttpHeaders();
		hh.add("jwt", "jkdfhskhflksdjflsd");
		hh.add("user", "admin");
		hh.add("hello", "abc");
		
	
		
		return new ResponseEntity<Student>(list.get(0),hh,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/students")
	public ResponseEntity<String> addStudentHandler(@RequestBody Student student) {
		
		students.add(student);
		
		//return "Student added Sucessfully..";
		
		return new ResponseEntity<String>("Student added successfully", HttpStatus.CREATED);
		
	}
	
	@PutMapping("/students/{roll}")
	public Student updateStudentHandler1(@RequestBody Student student, @PathVariable("roll") Integer roll) {
		
		boolean flag= true;
		
		for(Student st: students) {
			
			if(st.getRoll() == roll) {
				st.setName(student.getName());
				st.setMarks(student.getMarks());
				
				//st = student;
				flag = false;
				break;
			}
				
			
			
		}
		
		if(flag)
			throw new IllegalArgumentException("Student does not exist with Roll :"+roll);
			
		
		
		
		
		return student;
		
	}
	
	
	@DeleteMapping("/students/{roll}")
	public String deleteStudentByRollHandler(@PathVariable("roll") Integer roll) {
		
		boolean flag= students.removeIf(s -> s.getRoll() == roll);
		
		if(flag)
			return "Student Deleted Successfully";
		else
			throw new IllegalArgumentException("Student not found with Roll "+roll);
	}
	
	@PutMapping("/studentmarksupdate/{roll}")
	public String graceMarksHandler(@PathVariable("roll") Integer roll,@RequestParam("gmarks") Integer gmarks) {
		
		
		boolean flag= true;
		
		for(Student st: students) {
			
			if(st.getRoll() == roll) {
				
				st.setMarks(st.getMarks() + gmarks);
				
				
				flag = false;
				break;
			}
				
			
			
		}
		
		if(flag)
			throw new IllegalArgumentException("Student does not exist with Roll :"+roll);
			
		
		return "Student marks is Graced successfully..";
		
	}
	
	
	
	
	
	
	
	
}
