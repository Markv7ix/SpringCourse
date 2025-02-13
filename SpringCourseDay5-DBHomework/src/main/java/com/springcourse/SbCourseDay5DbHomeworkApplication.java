package com.springcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcourse.db.JdbcVehicleDAO;
import com.springcourse.model.Vehicle;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SbCourseDay5DbHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCourseDay5DbHomeworkApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		JdbcVehicleDAO jdbcVehicleDAO = context.getBean("jdbcVehicleDAO", JdbcVehicleDAO.class);
		
		Vehicle v1 = Vehicle.builder().idVehicle(0).model("Kawasaki Ninja").color("White").year(2001).seatNum(2).build();
		jdbcVehicleDAO.insert3(v1);
	}

}
