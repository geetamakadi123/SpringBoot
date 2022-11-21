package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.masai")
@PropertySource("a1.properties")
public class AppConfig {
	
	
	@Bean
	public List<String> getCities(){
		
		List<String> cities = new ArrayList<>();
		cities.add("delhi");
		cities.add("mumbai");
		cities.add("kolkata");
		cities.add("chennai");
		
		
		return cities;
	}
	
	@Bean("list")
	public List<String> getNames(){
		
		List<String> names = new ArrayList<>();
		names.add("Ravi");
		names.add("Chandan");
		names.add("Anand");
		names.add("Amit");
		
		
		return names;
	}
	
	
	
	

}
