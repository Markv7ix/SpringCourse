package com.springcourse;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcourse.auto.basics.Employee;

@SpringBootApplication
public class SbCourseDay3ComponentAnnotationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCourseDay3ComponentAnnotationProjectApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.springcourse.auto.basics");
		context.refresh();
		
		Employee employee1 = context.getBean("employee", Employee.class);
		Employee employee2 = context.getBean("employee", Employee.class);
		Employee employee3 = context.getBean("employee", Employee.class);
		
		Stream.of(employee1, employee2, employee3).forEach(System.out::println);
		System.out.println(employee1.equals(employee2) ? "Employee instances are same instance" : "Employee instances different instances");
		System.out.println(employee1.equals(employee3) ? "Employee instances are same instance" : "Employee instances different instances");

		System.out.println(employee1.getAddress().equals(employee2.getAddress()) ? "Address instances are same instance" : "Address instances different instances");
		System.out.println(employee1.getAddress().equals(employee3.getAddress()) ? "Address instances are same instance" : "Address instances different instances");
		
		
	}

}
