package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.valtech.viewAndModel.BikesVm;


public class BikesDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public void addBike(BikesVm bikes) {

		String sql = ("insert into Bikes (BikeID,OwnerName,OwnerContact,Model,ServiceDetails,ServiceManagerID,Status) values (?,?,?,?,?,?,?)");
		 jdbcTemplate.update(sql, bikes.getBikeID(), bikes.getOwnerName(), bikes.getOwnerContact(), bikes.getModel(),
				bikes.getServiceDetails(), bikes.getServiceManagerID(), bikes.getStatus());
	}
	
	
		public void updateBike(BikesVm bikes) {
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
	    
		public int save(BikesVm bikes){
			String sql = ("insert into Bikes (BikeID,OwnerName,OwnerContact,Model,ServiceDetails,ServiceManagerID,Status) values (?,?,?,?,?,?,?)");
			return jdbcTemplate.update(sql, bikes.getBikeID(), bikes.getOwnerName(), bikes.getOwnerContact(), bikes.getModel(),
					bikes.getServiceDetails(), bikes.getServiceManagerID(), bikes.getStatus());			

	    	}
	    
	    
		public BikesVm getBikeById(int id) {
	        String sql = "SELECT * FROM Bikes WHERE BikeID = ?";
				BikesVm	bikes=jdbcTemplate.queryForObject(sql, new Object[]{id},  new BikesRowMapper());
				return bikes;
	    }
	 
	    
	    
		public List<BikesVm> getBikesByServiceManagerId(int serviceManagerId) {
	        String sql = "SELECT * FROM bikes WHERE ServiceManagerID = ?";
	        return jdbcTemplate.query(sql, new Object[] { serviceManagerId }, new BikesRowMapper());
	    }
	    
		public List<BikesVm> getAllBikes() {
	        String sql = "SELECT * FROM bikes ";
	        return jdbcTemplate.query(sql, new Object[] { }, new BikesRowMapper());
	    }
//		public List<BikesVm> getAllBikes() {
//		    String sql = "SELECT * FROM bikes";
//		    return jdbcTemplate.query(sql, new Object[] {}, (rs, rowNum) -> {
//		        BikesVm bikes = new BikesVm();
//		        bikes.setBikeID(rs.getInt(1));
//		        bikes.setOwnerName(rs.getString(2));
//		        bikes.setOwnerContact(rs.getString(3));
//		        bikes.setModel(rs.getString(4));
//		        bikes.setServiceDetails(rs.getString(5));
//		        bikes.setServiceManagerID(rs.getInt(6));
//		        bikes.setStatus(rs.getString(7));
//		        return bikes;
//		    });
//		}

	    
	    class BikesRowMapper implements RowMapper<BikesVm> {
	        public BikesVm mapRow(ResultSet rs, int rowNum) throws SQLException {
	            BikesVm bikes = new BikesVm();
	            bikes.setBikeID(rs.getInt("bikeId"));
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










































