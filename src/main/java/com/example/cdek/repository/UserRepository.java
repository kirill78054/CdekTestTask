package com.example.cdek.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.example.cdek.model.UserProf;

public interface UserRepository {
	
	RowMapper<UserProf> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new UserProf(resultSet.getString("id"), resultSet.getString("username"), resultSet.getString("password"));
    };
	
    List<UserProf> findAll();
    
    String findOne(String userName);
    
    String findRoleUser(String userName);
    
    int add(UserProf user);
 
    int delete(int id);
	
}
