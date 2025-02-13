package com.springcourse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
	private Connection conn;

	public DBConnection() {
		try {
			this.conn = DriverManager.getConnection(JDBC_URL, "root", "P@ssw0rd!");
			if (this.conn != null) {
				System.out.println("connection successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}