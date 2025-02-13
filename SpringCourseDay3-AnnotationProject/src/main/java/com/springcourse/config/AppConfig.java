package com.springcourse.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcourse.Employee;
import com.springcourse.Passport;

@Configuration
public class AppConfig {

	@Bean
	public Employee employeeBean() {
		Employee employee = new Employee();
		employee.setEmpId(new Random().nextInt());
		employee.setEmpName("Mark");
		
		return employee;
	}
	
	@Bean
	public Passport passportBean() {
		Passport pass = new Passport();
		pass.setPassNum(new Random().nextLong());
		return pass;
	}
}
