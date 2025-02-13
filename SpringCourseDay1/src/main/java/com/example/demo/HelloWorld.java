package com.example.demo;

import java.util.List;

public class HelloWorld {

	private List<Holiday> holidays;
	
	private String message;
	
	public HelloWorld() {
	}
	
	public HelloWorld(List<Holiday> holidays, String message) {
		this.holidays = holidays;
		this.message = message;
	}

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorld [holidays=" + holidays + ", message=" + message + "]";
	}
	
	public void hello() {
		System.out.println("Hello " + message);
	}
}
