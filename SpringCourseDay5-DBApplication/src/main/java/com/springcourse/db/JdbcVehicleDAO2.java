package com.springcourse.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.springcourse.model.Vehicle;

@Component
public class JdbcVehicleDAO2 implements VehicleDAO {

	private static Logger logger = Logger.getLogger(JdbcVehicleDAO2.class.getName());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(Vehicle v) {
		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, v.getIdVehicle(), v.getModel(), v.getYear(), v.getColor(), v.getSeatNum());
		logger.log(Level.INFO, "Inserted succesfully: {0}", result);
	}
	
	public void insert1(Vehicle v) {
		int result = jdbcTemplate.update(new InsertVehicleStatementCreator(v));
		logger.log(Level.INFO, "Inserted succesfully: {0}", result);
	}
	
	public void insert2(Vehicle v) {
		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, v.getIdVehicle());
				ps.setString(2, v.getModel());
				ps.setInt(3, v.getYear());
				ps.setString(4, v.getColor());
				ps.setInt(5, v.getSeatNum());
			}
		});
		logger.log(Level.INFO, "Inserted succesfully: {0}", result);
	}

	public void insert3(Vehicle v) {
		String sql = "INSERT INTO vehicle (id_vehicle, model, year, color, seat_num) VALUES (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, new Object[] { v.getIdVehicle(), v.getModel(), v.getYear(), v.getColor(), v.getSeatNum() });
		logger.log(Level.INFO, "Inserted succesfully: {0}", result);
	}
	
	@Override
	public void update(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehicle> findAll() {
		logger.log(Level.INFO, "Retrieving all vehicles...");
		String sql = "SELECT * FROM VEHICLE";
		List<Vehicle> vehicleList = jdbcTemplate.query(sql, new VehicleRowMapper());
		
		logger.log(Level.INFO, "{0} vehicles found", vehicleList.size());
		return vehicleList;
	}
}
