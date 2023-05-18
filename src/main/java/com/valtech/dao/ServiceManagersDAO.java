package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valtech.model.ServiceManagers;
import com.valtech.model.User;

@Repository
public class ServiceManagersDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void addService(ServiceManagers serviceManagers) {
		String sql="insert into ServiceManagers(Name,Email,Contact,BranchID,role,password) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,serviceManagers.getName(),serviceManagers.getEmail(),
        serviceManagers.getContact(),serviceManagers.getBranchID(),serviceManagers.getRole(),serviceManagers.getPassword());
	}
	
	public List<ServiceManagers> getAllServiceManager(){

    	return jdbcTemplate.query("select * from ServiceManagers",new RowMapper<ServiceManagers>(){

    	public ServiceManagers mapRow(ResultSet rs, int row) throws SQLException {

    		ServiceManagers e=new ServiceManagers();
    		e.setServiceManagerID(rs.getInt(1));
    		e.setName(rs.getString(2));
    		e.setEmail(rs.getString(3));
    		e.setContact(rs.getString(4));
    		e.setBranchID(rs.getInt(5));
    		e.setRole(rs.getString(6));
    		e.setPassword(rs.getNString(7));
    	
    	return e;

    	
    	}

    	});
    }
	

	  public void updateServiceManagerateBike(ServiceManagers serviceManagers) {
	        String sql = "UPDATE serviceManagers SET  Name=?, Email=?, Contact=?, BranchID=? WHERE ServiceManagerID=?";
	        jdbcTemplate.update(sql,serviceManagers.getName(),serviceManagers.getEmail(),
	    	        serviceManagers.getContact(),serviceManagers.getBranchID(),serviceManagers.getServiceManagerID());
	    }
	    


	    public int deleteServiceManagers(int ServiceManagerID) {
	        String sql = "DELETE FROM ServiceManagers WHERE ServiceManagerID=?";
	        return jdbcTemplate.update(sql, ServiceManagerID);
	    
	}
	    
	    public void saveServiceManagers(ServiceManagers serviceManagers){
	    	String sql="insert into ServiceManagers(ServiceManagerID,Name,Email,Contact,BranchID,role,password) values(?,?,?,?,?,?,?)";
			 jdbcTemplate.update(sql,serviceManagers.getServiceManagerID(),serviceManagers.getName(),serviceManagers.getEmail(),
	        serviceManagers.getContact(),serviceManagers.getBranchID(),serviceManagers.getRole(),serviceManagers.getPassword());
		}
	    
	    
	    public ServiceManagers getServiceManagerById(int ServiceManagerID ) {
	        String sql = "SELECT * FROM ServiceManagers WHERE ServiceManagerID = ?";
	        ServiceManagers	serviceManagers=jdbcTemplate.queryForObject(sql, new Object[]{ServiceManagerID}, new BeanPropertyRowMapper<>(ServiceManagers.class));
				return serviceManagers;
	    }
	 
	    public ServiceManagers getByEmail(String email) {
	    	try {
	        String sql = "SELECT * FROM ServiceManagers WHERE Email = ?";
	        RowMapper<ServiceManagers> rowMapper = new BeanPropertyRowMapper<ServiceManagers>(ServiceManagers.class);
	        return jdbcTemplate.queryForObject(sql, rowMapper, email);
	    	}
	    	catch (EmptyResultDataAccessException e) {
				// TODO: handle exception
	    		return null;
			}
	    }  
	    
	    
	  
}
