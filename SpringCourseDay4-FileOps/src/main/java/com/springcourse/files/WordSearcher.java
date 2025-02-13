package com.springcourse.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component("searcher")
public class WordSearcher {
	
	
	private String filePath  = "C:\\projects\\workspace_in28course\\SBCourseDay4-FileOps\\src\\main\\resources\\butter.txt";
	private String searchWord ="butter";
	private LineNumberReader reader;
	public WordSearcher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WordSearcher(String filePath, String searchWord, LineNumberReader reader) {
		super();
		this.filePath = filePath;
		this.searchWord = searchWord;
		this.reader = reader;
	}
	
	@PostConstruct
	public void openFile() throws FileNotFoundException
	{
		reader = new LineNumberReader(new FileReader(filePath));
		System.out.println("In openfile " + filePath);
	}
	
	@PreDestroy
	public void closeFile()
	{
		try {
			reader.close();
			System.out.println("In closeFile" + filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public WordPosition[] search() throws IOException
	{
		List positions = new ArrayList();
		String line = reader.readLine();
		while(line != null)
		{
			String []words = line.split(" ");
			int startIndex = 0;
			for(int i =0 ; i < words.length; i++)
			{
				String word = words[i];
				if(word.equalsIgnoreCase(searchWord))
				{
					int column = line.indexOf(word, startIndex);
					positions.add(new WordPosition(reader.getLineNumber(),++column));
					startIndex = column + word.length();
				}
			}
			reader.readLine();
		}
		
		return (WordPosition[]) positions.toArray(new WordPosition[positions.size()]);
		
	}
	
	

}