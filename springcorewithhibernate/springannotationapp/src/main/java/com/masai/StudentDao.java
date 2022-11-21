package com.masai;

import java.util.List;

public interface StudentDao {
	
	
	public String insertStudentDetails(Student student);
	
	public List<Student> getAllStudentDetails();

}
