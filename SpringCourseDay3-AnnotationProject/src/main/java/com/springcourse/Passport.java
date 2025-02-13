package com.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Passport {

	private long passNum;

	public long getPassNum() {
		return passNum;
	}

	public void setPassNum(long passNum) {
		this.passNum = passNum;
	}

	public Passport(long passNum) {
		super();
		this.passNum = passNum;
	}

	public Passport() {
		super();
	}

	@Override
	public String toString() {
		return "Passport [passNum=" + passNum + "]";
	}
}
