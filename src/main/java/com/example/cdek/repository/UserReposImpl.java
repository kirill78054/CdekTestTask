package com.example.cdek.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.cdek.model.UserProf;

@Component
public class UserReposImpl implements UserRepository {
	private static final Logger log = Logger.getLogger(UserReposImpl.class);
	private JdbcTemplate jdbcTemplate;
	 
    @Autowired
    public void PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public List<UserProf> findAll() {
		return jdbcTemplate.query("select * from urs", ROW_MAPPER);
	}

	@Override
	public int add(UserProf user) {
		return jdbcTemplate.update("INSERT INTO `usr` (`id`, `active`, `password`, `username`, `id_role`) VALUES (NULL, b'1', '" + user.getPassword() + "', '" + user.getUsername() +"', '" + user.getRoles() + "')");
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from `orders` where id_order = ?", id);
	}

	@Override
	public String findOne(String userName) {	
		String UserProf = null;
		try {
		UserProf = jdbcTemplate.queryForObject("SELECT username FROM usr WHERE username=?", String.class, userName);
		} catch (DataAccessException dataAccessException) {  
			log.error("Исключение типа: " + dataAccessException);
			return null;
        }
        return UserProf;
	}

	@Override
	public String findRoleUser(String userName) {
		String UserProf = null;
		UserProf = jdbcTemplate.queryForObject("SELECT id_role FROM usr WHERE username=?", String.class, userName);		
        return UserProf;
	}

}
