package com.springcourse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.springcourse.model.Vehicle;

public class JdbcVehicleDAO {

	String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
	
	private Connection conn;
	
	public void insert(Vehicle v) {
		// TODO Auto-generated method stub
		String sql = //"INSERT VEHICLE(VEHICLE_NO, COLOR,WHEEL,SEAT) VALUES(?,?,?,?)";
		"""
		INSERT INTO testdb.vehicle
				(ID_VEHICLE, MODEL, YEAR, COLOR, SEAT_NUM)
				VALUES(?, ?, ?, ?, ?);
		""";
		try {
			this.conn = DriverManager.getConnection(JDBC_URL, "root", "P@ssw0rd!");
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, v.getIdVehicle());
			ps.setString(2, v.getModel());
			ps.setInt(3, v.getYear());
			ps.setString(4, v.getColor());
			ps.setInt(5, v.getSeatNum());
			ps.executeUpdate();
			ps.close();
			System.out.println("insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
