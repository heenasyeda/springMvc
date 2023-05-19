package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.valtech.model.Bikes;



public class BikesDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addBike(Bikes bikes) {

		String sql = ("insert into Bikes (BikeID,OwnerName,OwnerContact,Model,ServiceDetails,ServiceManagerID,Status) values (?,?,?,?,?,?,?)");
		 jdbcTemplate.update(sql, bikes.getBikeID(), bikes.getOwnerName(), bikes.getOwnerContact(), bikes.getModel(),
				bikes.getServiceDetails(), bikes.getServiceManagerID(), bikes.getStatus());
	}
	
	
	    public void updateBike(Bikes bikes) {
	        String sql = "UPDATE Bikes SET OwnerName=?, OwnerContact=?, Model=?, ServiceDetails=?, ServiceManagerID=?, Status=? WHERE BikeID=?";
	        jdbcTemplate.update(sql, bikes.getOwnerName(), bikes.getOwnerContact(), bikes.getModel(), bikes.getServiceDetails(), bikes.getServiceManagerID(), bikes.getStatus(), bikes.getBikeID());
	    }
	    

	   
	    public void deleteBike(int bikeID) {
	    	try {
	        String sql = "DELETE FROM Bikes WHERE BikeID=?";
	         jdbcTemplate.update(sql, bikeID);
	    	}
	    	catch (EmptyResultDataAccessException e) {
				// TODO: handle exception
			}
	    
    	}
	    
	    public int save(Bikes bikes){
			String sql = ("insert into Bikes (BikeID,OwnerName,OwnerContact,Model,ServiceDetails,ServiceManagerID,Status) values (?,?,?,?,?,?,?)");
			return jdbcTemplate.update(sql, bikes.getBikeID(), bikes.getOwnerName(), bikes.getOwnerContact(), bikes.getModel(),
					bikes.getServiceDetails(), bikes.getServiceManagerID(), bikes.getStatus());			

	    	}
	    
	    
	    public Bikes getBikeById(int id) {
	        String sql = "SELECT * FROM Bikes WHERE BikeID = ?";
				Bikes	bikes=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Bikes.class));
				return bikes;
	    }
	 
	    
	    
	    public List<Bikes> getBikesByServiceManagerId(int serviceManagerId) {
	        String sql = "SELECT * FROM bikes WHERE ServiceManagerID = ?";
	        return jdbcTemplate.query(sql, new Object[] { serviceManagerId }, new BikesRowMapper());
	    }
	    
	    public List<Bikes> getAllBikes() {
	        String sql = "SELECT * FROM bikes ";
	        return jdbcTemplate.query(sql, new Object[] { }, new BikesRowMapper());
	    }
	    
	    class BikesRowMapper implements RowMapper<Bikes> {
	        public Bikes mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Bikes bikes = new Bikes();
	            bikes.setBikeID(rs.getInt(1));
	            bikes.setOwnerName(rs.getString(2));
	            bikes.setOwnerContact(rs.getString(3));
	            bikes.setModel(rs.getString(4));
	            bikes.setServiceDetails(rs.getString(5));
	            bikes.setServiceManagerID(rs.getInt(6));
	            bikes.setStatus(rs.getString(7));
	            return bikes;
	        }

	    }
}










































//public List<Bikes> getAllBikes(){
//return jdbcTemplate.query("select * from Bikes",new RowMapper<Bikes>(){
//public Bikes mapRow(ResultSet rs, int row) throws SQLException {
//	Bikes e=new Bikes();
//	e.setBikeID(rs.getInt(1));
//	e.setOwnerName(rs.getString(2));
//	e.setOwnerContact(rs.getString(3));
//	e.setModel(rs.getString(4));
//	e.setServiceDetails(rs.getString(5));
//	e.setServiceManagerID(rs.getInt(6));
//	e.setStatus(rs.getString(7));    		
//return e;	
//}
//});
//}
//