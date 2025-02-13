package com.springcourse.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.springcourse.model.Vehicle;

@Component
public class JdbcVehicleDAO implements VehicleDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Vehicle v) {
		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, v.getIdVehicle(), v.getModel(), v.getYear(), v.getColor(), v.getSeatNum());
	}
	
	public void insert1(Vehicle v) {
		jdbcTemplate.update(new InsertVehicleStatementCreator(v));
	}
	
	public void insert2(Vehicle v) {
		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, v.getIdVehicle());
				ps.setString(2, v.getModel());
				ps.setInt(3, v.getYear());
				ps.setString(4, v.getColor());
				ps.setInt(5, v.getSeatNum());
			}
		});
	}

	public void insert3(Vehicle v) {
		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, new Object[] { v.getIdVehicle(), v.getModel(), v.getYear(), v.getColor(), v.getSeatNum() });
		
		System.out.println("Inserted succefully " + result);
	}
	
	@Override
	public void update(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehicle v) {
		// TODO Auto-generated method stub
		
	}
}
