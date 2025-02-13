package com.example.demo;

public class Holiday {

	private int month;
	
	private int day;
	
	private String greetings;
	
	public Holiday() {
	}
	
	public Holiday(int month, int day, String name) {
		this.month = month;
		this.day = day;
		this.greetings = name;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		System.out.println("Setting month");
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	@Override
	public String toString() {
		return "Holiday [month=" + month + ", day=" + day + ", greetings=" + greetings + "]";
	}
}
