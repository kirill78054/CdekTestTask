package com.example.cdek.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.cdek.model.OrderClient;

@Component
public class OrderReposImp implements OrderRepository{
	
	
    private JdbcTemplate jdbcTemplate;
 
    @Autowired
    public void PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
		
    @Override
    public List<OrderClient> findAll() {
    	return jdbcTemplate.query("select * from orders", ROW_MAPPER);
    }
    
    @Override
    public List<OrderClient> findAllStatus(String value) {
    	return jdbcTemplate.query("select * from orders where status = '" + value + "'", ROW_MAPPER);
    }
    
 
    @Override
    public OrderClient findOne(String id) {
    	OrderClient orderClient = null;
        orderClient = jdbcTemplate.queryForObject("select * from orders where id = ?", new Object[]{id}, ROW_MAPPER);
        return orderClient;
    }
 
    @Override
    public int save(OrderClient orderClient) {
    	return jdbcTemplate.update("INSERT INTO `orders` (`id`, `title`, `address`, `status`, `datenot`) VALUES "
    			+ "(NULL, ' " + orderClient.getTitle() + " ', '"+ orderClient.getAddress() +"', 'COURIER', '')");    	 
    }    
 
    @Override
    public int delete(int id) {
    	return jdbcTemplate.update("delete from orders where id = ?", id);
    }

	@Override
	public int changeStatus(String value, String id) {
		return jdbcTemplate.update("UPDATE `orders` SET `status` = '" + value + "' WHERE `orders`.`id` = '" + id + "'");
	}

	@Override
	public int changeDate(String value, String id) {
		return jdbcTemplate.update("UPDATE `orders` SET `datenot` = '" + value + "' WHERE `orders`.`id` = '" + id + "'");
	}

}
