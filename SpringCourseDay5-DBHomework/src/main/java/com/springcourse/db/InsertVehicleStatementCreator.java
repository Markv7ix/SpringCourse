package com.springcourse.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.springcourse.model.Vehicle;

public class InsertVehicleStatementCreator implements PreparedStatementCreator {

	private Vehicle vehicle;
	
	public InsertVehicleStatementCreator(Vehicle vehicle) {
        this.vehicle = vehicle;
	}
	
	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vehicle.getIdVehicle());
		ps.setString(2, vehicle.getModel());
		ps.setInt(3, vehicle.getYear());
		ps.setString(4, vehicle.getColor());
		ps.setInt(5, vehicle.getSeatNum());
		
		return ps;
	}

}
