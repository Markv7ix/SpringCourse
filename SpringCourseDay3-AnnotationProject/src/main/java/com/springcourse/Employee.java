package com.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String empName;
	
	private int empId;
	@Autowired
	private Passport passport;
	public Employee() {
		super();
	}
	public Employee(String empName, int empId, Passport passport) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.passport = passport;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", passport=" + passport + "]";
	}
	
}
