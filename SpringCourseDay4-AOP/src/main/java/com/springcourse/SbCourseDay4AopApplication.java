package com.springcourse;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springcourse", "com.springcourse.*"})
public class SbCourseDay4AopApplication {

	static Logger logger = Logger.getLogger(SbCourseDay4AopApplication.class.getSimpleName());
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbCourseDay4AopApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.springcourse", "com.springcourse.aop");
//		context.refresh();
		
		Account account = context.getBean("account", Account.class);
		logger.log(Level.INFO, "Account balance {0}", account.getBalance());
		account.credit(5000);
		logger.log(Level.INFO, "Account balance {0}", account.getBalance());
		account.credit(7000);
		logger.log(Level.INFO, "Account balance {0}", account.getBalance());
		account.debit(350);
		logger.log(Level.INFO, "Account balance {0}", account.getBalance());
		account.debit(500);
		logger.log(Level.INFO, "Account balance {0}", account.getBalance());
		
	}

}
