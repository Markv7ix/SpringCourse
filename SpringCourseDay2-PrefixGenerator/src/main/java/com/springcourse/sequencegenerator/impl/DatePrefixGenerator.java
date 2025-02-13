package com.springcourse.sequencegenerator.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.springcourse.sequencegenerator.PrefixGenerator;

public class DatePrefixGenerator implements PrefixGenerator {

	private String pattern;
	
	public DatePrefixGenerator() {
		super();
	}

	public DatePrefixGenerator(String pattern) {
		super();
		this.pattern = pattern;
	}
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String generatePrefix() {
		DateFormat dateFormat = new SimpleDateFormat(this.pattern);
		return dateFormat.format(new java.util.Date());
	}

}
