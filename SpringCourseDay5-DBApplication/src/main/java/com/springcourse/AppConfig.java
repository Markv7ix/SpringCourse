package com.springcourse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		Properties props = new Properties();
		props.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
		props.setProperty("url", "jdbc:mysql://localhost:3306/testdb");
		props.setProperty("username", "root");
		props.setProperty("password", "P@ssw0rd!");
		props.setProperty("initialSize", "2");
		props.setProperty("maxActive", "5");
		return BasicDataSourceFactory.createDataSource(props);
	}
}
