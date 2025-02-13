package com.springcourse.auto.basics;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SocialSecurity {

	@Value("NE")
	private String area;
	@Value("AB")
	private String group;
	private long serial;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
//	public SocialSecurity(String area, String group, long serial) {
//		super();
//		this.area = area;
//		this.group = group;
//		this.serial = serial;
//	}
	public SocialSecurity() {
		super();
		this.serial = new Random().nextLong(); 
	}
	@Override
	public String toString() {
		return "SocialSecurity [area=" + area + ", group=" + group + ", serial=" + serial + "]";
	}
}
