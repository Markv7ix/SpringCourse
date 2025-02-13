package com.springcourse.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class FileOperationsImpl {

	private String filePath = "src/main/resources/butter.txt";
	private FileReader fileReader;

	@Autowired
	public FileOperationsImpl() {

	}

	public FileOperationsImpl(String filePath) {
		super();
		this.filePath = filePath;
	}

	public long searchCount(String searchWord) {
		if (fileReader == null) {
			return -1;
		}

		
		String line = null;
		long accumulator = 0;
		try (BufferedReader br = new BufferedReader(fileReader);) {
			while ((line = br.readLine()) != null) {
				accumulator += Stream.of(line.split(" ")).filter(searchWord::equalsIgnoreCase).count();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accumulator;
	}

	@PostConstruct
	public void openFile() {
		System.out.println("Initializing filereader...");
		try {
			this.fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PreDestroy
	public void closeFile() {
		System.out.println("Destroying filereader..");
		try {
			this.fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		FileOperationsImpl fileOps = new FileOperationsImpl();
		fileOps.openFile();
		System.out.println("Number of times: " + fileOps.searchCount("bitter"));
		fileOps.closeFile();
	}
}
