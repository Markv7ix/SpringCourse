package com.springcourse;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcourse.files.FileOperationsImpl;
import com.springcourse.files.WordPosition;
import com.springcourse.files.WordSearcher;

@SpringBootApplication
public class SbCourseDay4FileOpsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SbCourseDay4FileOpsApplication.class, args);
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.springcourse");
		appContext.refresh();
		
		FileOperationsImpl fileOps = appContext.getBean("fileOperationsImpl", FileOperationsImpl.class);
		System.out.println("Number of times: " + fileOps.searchCount("Betty"));
	
		WordSearcher searcher = appContext.getBean("searcher", WordSearcher.class);
		WordPosition [] positions = searcher.search();
		for(WordPosition wordPositon : positions) {
			System.out.println(wordPositon);
		}
		
	}

}
