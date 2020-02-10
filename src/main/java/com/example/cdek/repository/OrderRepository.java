package com.example.cdek.repository;

import com.example.cdek.model.OrderClient;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public interface OrderRepository {
	
	RowMapper<OrderClient> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new OrderClient(resultSet.getString("id"), resultSet.getString("title"), resultSet.getString("address"), resultSet.getString("datenot"), resultSet.getString("status"));
    };
	
    List<OrderClient> findAll();
    
    List<OrderClient> findAllStatus(String value);
 
    OrderClient findOne(String id);
 
    int save(OrderClient orderClient);
 
    int delete(int id);
    
    int changeStatus(String value, String id);
    
    int changeDate(String value, String id);
    
    
	
}
