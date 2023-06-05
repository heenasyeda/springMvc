package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.valtech.viewAndModel.UserVm;


public class UserDAO {
	
	    @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    

	    

	    // Create a new user
	    public void createUser(UserVm user) {
	        String sql = "INSERT INTO user (userName, password, email, role) VALUES ( ?, ?, ?,?)";
	        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
	    }
        
	        
	        //save method
	        public int save(UserVm user) {
	            String sql = "INSERT INTO user (userId,userName, password, email, role) VALUES (?, ?, ?, ?,?)";
	            return jdbcTemplate.update(sql,user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
	        }
	        
	        public List<UserVm> getUsers(){
	        	
				return jdbcTemplate.query("select * from user ", new RowMapper<UserVm>(){
					public UserVm mapRow(ResultSet rs,int row) throws SQLException{
						UserVm li= new UserVm();
						li.setUserId(rs.getInt(1));
						li.setUsername(rs.getString(2));
			            li.setPassword(rs.getString(3));
			            li.setEmail(rs.getString(4));
			            li.setRole(rs.getString(5));
			            return li;  
					}
				});
	        	
	        }
	    
	    // Update a user
	    public void updateUser(UserVm user) {
	        String sql = "UPDATE user SET userName = ?, password = ?, email = ?, role = ? WHERE userId = ?";
	        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRole(), user.getUserId());
	    }

	    // Delete a user by ID
	    public void deleteUser(int userId) {
	        String sql = "DELETE FROM user  WHERE   userId = ?";
	        jdbcTemplate.update(sql, userId);
	    }
	 
	    public UserVm getUserbyId(int userId) {
	    	String sql = "SELECT * FROM user WHERE userId = ?";
	    	UserVm user = jdbcTemplate.queryForObject(sql, new Object[] { userId }, new BeanPropertyRowMapper<UserVm>(UserVm.class));
	    	return user;

	    	}
	    public UserVm getUserbyUserName(String username) {
	    	String sql = "SELECT * FROM user WHERE username = ?";
	    	UserVm user = jdbcTemplate.queryForObject(sql, new Object[] { username }, new BeanPropertyRowMapper<UserVm>(UserVm.class));
	    	return user;

	    	}
			 
	    
	    public UserVm findByEmail(String email) {
	    	try {
	        String sql = "SELECT * FROM User WHERE Email = ?";
	        RowMapper<UserVm> rowMapper = new BeanPropertyRowMapper<UserVm>(UserVm.class);
	        return jdbcTemplate.queryForObject(sql, rowMapper, email);
	    	}
	    	catch (EmptyResultDataAccessException e) {
				// TODO: handle exception
	    		return null;
			}
	    } 
	    
	    public UserVm findUserByMailAndPassword(String email,String password) {
	    	 String sql="select * from user where email=? AND password=?";
	    	 RowMapper<UserVm> rowMapper = new BeanPropertyRowMapper<UserVm>(UserVm.class);
	    	 return jdbcTemplate.queryForObject(sql, rowMapper,email,password);
	    	

	    	}
	}


