package com.springcourse.db;

import java.util.List;

import com.springcourse.model.Vehicle;

public interface VehicleDAO {
	
	public void insert(Vehicle v);
	public void update(Vehicle v);
	public void delete(Vehicle v);
	public List<Vehicle> findAll();

}
