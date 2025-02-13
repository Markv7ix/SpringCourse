package com.springcourse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Account {

	@Value("1000")
	private double balance;

	public Account() {
	}
	
	public void debit(double amount) {
		this.balance -= amount;
	}
	
	public void credit(double amount) {
		this.balance += amount;
	}
	
	public double getBalance() {
		return this.balance;
	}
}
