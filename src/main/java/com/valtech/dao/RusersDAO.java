package com.valtech.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.valtech.model.Rusers;

@Repository
public class RusersDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void saveUser(Rusers rusers) {
		String sql = " insert into  rusers (name,email,password,role) values (?,?,?,?)";
		jdbcTemplate.update(sql,rusers.getName(),rusers.getEmail(),rusers.getPassword(),rusers.getRole());
				
		
	}
	

}


