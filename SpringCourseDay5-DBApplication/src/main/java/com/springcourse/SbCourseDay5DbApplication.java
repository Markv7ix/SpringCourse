package com.springcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springcourse.db.JdbcVehicleDAO2;
import com.springcourse.model.Vehicle;

@SpringBootApplication
@ComponentScan(basePackages = "com.springcourse")
public class SbCourseDay5DbApplication {

	private static Logger logger = Logger.getLogger(SbCourseDay5DbApplication.class.getName());
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbCourseDay5DbApplication.class, args);
		
	        //DBConnection db = new DBConnection();
	        
//	        Vehicle v = new Vehicle();
//	        v.setIdVehicle(123);
//	        v.setModel("Dodge Charger");
//	        v.setColor("Orange");
//	        v.setSeatNum(4);
//	        v.setYear(2021);
//	        
//	        JdbcVehicleDAO jd = new JdbcVehicleDAO();
//	        jd.insert(v);
		
		JdbcVehicleDAO2 jdbcVehicle2 = context.getBean("jdbcVehicleDAO2", JdbcVehicleDAO2.class);
		List<Vehicle> vehicles = getAllVehicles();
		jdbcVehicle2.insert(vehicles.get(0));
		jdbcVehicle2.insert1(vehicles.get(1));
		jdbcVehicle2.insert2(vehicles.get(2));
		jdbcVehicle2.insert3(vehicles.get(3));
		
		logger.log(Level.INFO, "Retrieving records from DB");
		List<Vehicle> dbVehicleList = jdbcVehicle2.findAll();
		dbVehicleList.forEach((o) -> logger.log(Level.INFO, o.toString()));
	}

	private static List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		
		vehicles.add(Vehicle.builder().idVehicle(1).model("Toyota Corolla").year(2021).color("Blue").seatNum(5).build());
		vehicles.add(Vehicle.builder().idVehicle(2).model("Apache Blackhawk").year(1972).color("Blue").seatNum(8).build());
		vehicles.add(Vehicle.builder().idVehicle(3).model("VW Jetta A4").year(1999).color("Gray").seatNum(5).build());
		vehicles.add(Vehicle.builder().idVehicle(4).model("Ford Fiesta").year(2003).color("Red").seatNum(4).build());
		vehicles.add(Vehicle.builder().idVehicle(5).model("Honda Civic").year(2010).color("Silver").seatNum(5).build());
		
		return vehicles;
	}
}
