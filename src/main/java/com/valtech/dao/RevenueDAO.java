package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valtech.model.Revenue;

@Repository

public class RevenueDAO {
	

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void saveRevenue(Revenue revenue) {
    	String sql="insert into Revenue(RevenueID,BranchID,RevenueAmount,TimePeriod,serviceManagerID) values (?,?,?,?,?)";
     jdbcTemplate.update(sql,revenue.getRevenueID(),revenue.getBranchID(),revenue.getRevenueAmount(),revenue.getTimePeriod(),revenue.getServiceManagerID());
    }

    
    private class RevenueMapper implements RowMapper<Revenue> {
	    public Revenue mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Revenue revenue = new Revenue();
	    	revenue.setRevenueID(rs.getInt(1));
	    	revenue.setBranchID(rs.getInt(2));
	    	revenue.setRevenueAmount(rs.getInt(3));
	    	revenue.setTimePeriod(rs.getString(4));
	    	revenue.setServiceManagerID(rs.getInt(5));
	        return revenue;
	    }
	    
    }
    
    
    public List<Revenue> getAllRevenue() {
	    String sql = "SELECT * FROM Revenue";
	    return jdbcTemplate.query(sql, new RevenueMapper());
	}
    
    
    public List<Object[]> getRevenueByBranch() {
        String sql = "SELECT Branches.Name, SUM(Revenue.RevenueAmount) AS TotalRevenue " +
                     "FROM Branches " +
                     "LEFT JOIN Revenue ON Branches.BranchID = Revenue.BranchID " +
                     "GROUP BY Branches.Name";

        List<Object[]> revenueByBranch = jdbcTemplate.query(sql, new RowMapper<Object[]>() {
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] row = new Object[2];
                row[0] = rs.getString("Name");
                row[1] = rs.getInt("TotalRevenue");
                return row;
            }
        });
        
        return revenueByBranch;
    }


    public List<Object[]> getRevenueByServiceManager() {
        String sql = "SELECT ServiceManagers.Name, SUM(Revenue.RevenueAmount) AS TotalRevenue " +
                     "FROM ServiceManagers " +
                     "LEFT JOIN Revenue ON ServiceManagers.serviceManagerID = Revenue.serviceManagerID " +
                     "GROUP BY ServiceManagers.Name";
        return jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] row = new Object[2];
                row[0] = rs.getString("Name");
                row[1] = rs.getInt("TotalRevenue");
                return row;
            }
        });
    }

    public int getTotalRevenue() {
        String sql = "SELECT SUM(RevenueAmount) FROM Revenue";
        Integer totalRevenue = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(totalRevenue);
        return totalRevenue != null ? totalRevenue : 0;
    }

}


