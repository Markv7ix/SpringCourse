package com.springcourse.auto.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Address {

	@Value("Ben Franklin")
	private String street;
	@Value("Boston")
	private String city;
	@Value("MA")
	private String state;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
//	public Address(String street, String city, String state) {
//		super();
//		this.street = street;
//		this.city = city;
//		this.state = state;
//	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + "]";
	}
}
