package com.example.cdek.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseModel {
	
	@Autowired	
	static JdbcTemplate jdbcTemplate;
	
	public static String findAllOrders() {
		jdbcTemplate.execute("SELECT * FROM `orders`");
		return "";
	}
}
