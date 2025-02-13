package com.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

	private int idVehicle;
	
	private String model;
	
	private int year;
	
	private String color;
	
	private int seatNum;
	
}
