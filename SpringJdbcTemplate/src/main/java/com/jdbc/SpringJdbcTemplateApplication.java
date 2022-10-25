package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcTemplateApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		String sql="INSERT into students(\"studentId\",\"courseId\", \"studentName\", \"studentEmail\", \"studentPhone\") "
				+ "VALUES(15,15,'name5','name5@gmail.com',1234)";
		int rows=jdbcTemplate.update(sql);
		
		if(rows>0) {
			System.out.println("A row has been inserted");
		}
		
		
		
	}

}
