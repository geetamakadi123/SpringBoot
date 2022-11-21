package com.masai;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	@GetMapping("/hello/{id}")
	public ResponseEntity<String> sayHello(@PathVariable("id") Integer id)  {
		
		if(id > 10) {
		
			int result = id/0; //AE
			
			return new ResponseEntity<String>("Welcome to Spring Boot", HttpStatus.ACCEPTED);
		
		}
			else
			throw new InvalidIdException("Invalid Id value");
		
		
		
		
	}
	
	
	
}
