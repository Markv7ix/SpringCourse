package com.springcourse.auto.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {

	@Value("John Wick")
	private String name;
//	@Autowired
	private SocialSecurity socialSecurity;
//	@Autowired
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SocialSecurity getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(SocialSecurity socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Autowired
	public Employee(SocialSecurity socialSecurity, Address address) {
		this.socialSecurity = socialSecurity;
		this.address = address;
	}
	
	public Employee(String name, SocialSecurity socialSecurity, Address address) {
		super();
		this.name = name;
		this.socialSecurity = socialSecurity;
		this.address = address;
	}
	
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", socialSecurity=" + socialSecurity + ", address=" + address + "]";
	}
}
