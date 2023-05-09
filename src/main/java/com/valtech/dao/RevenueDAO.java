package com.valtech.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.valtech.model.Revenue;

@Repository
public class RevenueDAO {
	

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void saveRevenue(Revenue revenue) {
    	String sql="insert into Revenue(RevenueID,BranchID,RevenueAmount,TimePeriod) values (?,?,?,?)";
     jdbcTemplate.update(sql,revenue.getRevenueID(),revenue.getBranchID(),revenue.getRevenueAmount(),revenue.getTimePeriod());
    }

}


