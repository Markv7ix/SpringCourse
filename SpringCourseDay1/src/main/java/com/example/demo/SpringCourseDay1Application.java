package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCourseDay1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseDay1Application.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		HelloWorld helloWorld = context.getBean("HelloWorld", HelloWorld.class);
		
		helloWorld.hello();
	}

}
