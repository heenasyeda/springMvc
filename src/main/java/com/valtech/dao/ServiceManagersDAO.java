package com.valtech.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.valtech.model.ServiceManagers;

@Repository
public class ServiceManagersDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void saveService(ServiceManagers serviceManagers) {
		String sql="insert into ServiceManagers(ServiceManagerID,Name,Email,Contact,BranchID) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,serviceManagers.getServiceManagerID(),serviceManagers.getName(),serviceManagers.getEmail(),
        serviceManagers.getContact(),serviceManagers.getBranchID());
	}
}
