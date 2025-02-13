package com.springcourse;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcourse.sequencegenerator.impl.CountdownSequenceGenerator;
import com.springcourse.sequencegenerator.impl.SequenceGenerator;

@SpringBootApplication
public class PrefixGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrefixGeneratorApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		SequenceGenerator generator = context.getBean("sequenceGenerator", SequenceGenerator.class);
		
        System.out.println(generator.getNext());
        System.out.println(generator.getNext());
        
        CountdownSequenceGenerator tsSeqGenerator = context.getBean("countdownSequenceGenerator", CountdownSequenceGenerator.class);
		
        Stream.generate(() -> tsSeqGenerator.getNext()).limit(105).forEach(System.out::println);
	}

}
