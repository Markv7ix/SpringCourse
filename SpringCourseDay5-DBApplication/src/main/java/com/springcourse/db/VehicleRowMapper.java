package com.springcourse.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springcourse.model.Vehicle;

public class VehicleRowMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Vehicle.builder()
				.idVehicle(rs.getInt("ID_VEHICLE"))
				.model(rs.getString("MODEL"))
				.year(rs.getInt("YEAR"))
				.color("color")
				.seatNum(rs.getInt("SEAT_NUM")).build();
	}

}
