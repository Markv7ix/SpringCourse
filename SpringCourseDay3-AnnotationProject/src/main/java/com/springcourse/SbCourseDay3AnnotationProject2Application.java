package com.springcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcourse.config.AppConfig;

@SpringBootApplication
public class SbCourseDay3AnnotationProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbCourseDay3AnnotationProject2Application.class, args);
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Employee employee = context.getBean("employeeBean", Employee.class);
		System.out.println(employee);
		Passport passport = context.getBean("passportBean", Passport.class);
		System.out.println(passport);
	}

}
