package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.valtech.viewAndModel.ServiceManagersVm;


public class ServiceManagersDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addService(ServiceManagersVm serviceManagers) {
		String sql = "insert into ServiceManagers(Name,Email,Contact,BranchID,role,password) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, serviceManagers.getName(), serviceManagers.getEmail(), serviceManagers.getContact(),
				serviceManagers.getBranchID(), serviceManagers.getRole(), serviceManagers.getPassword());
	}

	public void updateServiceManagerateBike(ServiceManagersVm serviceManagers) {
		String sql = "UPDATE serviceManagers SET  Name=?, Email=?, Contact=?, BranchID=? WHERE ServiceManagerID=?";
		jdbcTemplate.update(sql, serviceManagers.getName(), serviceManagers.getEmail(), serviceManagers.getContact(),
				serviceManagers.getBranchID(), serviceManagers.getServiceManagerID());
	}

	public int deleteServiceManagers(int ServiceManagerID) {
		String sql = "DELETE FROM ServiceManagers WHERE ServiceManagerID=?";
		return jdbcTemplate.update(sql, ServiceManagerID);

	}

	public void saveServiceManagers(ServiceManagersVm serviceManagers) {
		String sql = "insert into ServiceManagers(ServiceManagerID,Name,Email,Contact,BranchID,role,password) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, serviceManagers.getServiceManagerID(), serviceManagers.getName(),
				serviceManagers.getEmail(), serviceManagers.getContact(), serviceManagers.getBranchID(),
				serviceManagers.getRole(), serviceManagers.getPassword());
	}

	public ServiceManagersVm getServiceManagerById(int ServiceManagerID) {
		String sql = "SELECT * FROM ServiceManagers WHERE ServiceManagerID = ?";
		ServiceManagersVm serviceManagers = jdbcTemplate.queryForObject(sql, new Object[] { ServiceManagerID },
				new BeanPropertyRowMapper<>(ServiceManagersVm.class));
		return serviceManagers;
	}

	public ServiceManagersVm getByEmail(String email) {
		try {
			String sql = "SELECT * FROM ServiceManagers WHERE Email = ?";
			RowMapper<ServiceManagersVm> rowMapper = new BeanPropertyRowMapper<ServiceManagersVm>(ServiceManagersVm.class);
			return jdbcTemplate.queryForObject(sql, rowMapper, email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public ServiceManagersVm getManagerByName(String name) {
		String sql = "SELECT * FROM ServiceManagers WHERE Name=?";
		ServiceManagersVm serviceManagers = jdbcTemplate.queryForObject(sql, new Object[] {name},
				new BeanPropertyRowMapper<ServiceManagersVm>(ServiceManagersVm.class));
		return serviceManagers;

	}
	
	public ServiceManagersVm sortManagerByAscending(int ServiceManagerID ) {
		String sql = "SELECT * FROM ServiceManagers WHERE ServiceManagerID = ? Order By ServiceManagerID ASC";
		ServiceManagersVm serviceManagers = jdbcTemplate.queryForObject(sql, new Object[] {ServiceManagerID},
				new BeanPropertyRowMapper<ServiceManagersVm>(ServiceManagersVm.class));
		return serviceManagers;

	}
	
	

	public List<ServiceManagersVm> getAllServiceManager() {
		String sql="select * from ServiceManagers";
		return jdbcTemplate.query(sql, new Object[] { }, new ServiceManagerRowMapper());
	}	
	
	public List<ServiceManagersVm> getAllServiceManagerInAscending() {
		String sql="SELECT * FROM ServiceManagers  ORDER BY ServiceManagerID ASC";
		return jdbcTemplate.query(sql, new Object[] { }, new ServiceManagerRowMapper());
	}	
	
	public List<ServiceManagersVm> getAllServiceManagerInDecending() {
		String sql="select * from ServiceManagers ORDER BY ServiceManagerId DESC";
		return jdbcTemplate.query(sql, new Object[] { }, new ServiceManagerRowMapper());
	}	
	
	
	class ServiceManagerRowMapper implements RowMapper<ServiceManagersVm>{
			public ServiceManagersVm mapRow(ResultSet rs, int row) throws SQLException {
				ServiceManagersVm e = new ServiceManagersVm();
				e.setServiceManagerID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setContact(rs.getString(4));
				e.setBranchID(rs.getInt(5));
				e.setRole(rs.getString(6));
				e.setPassword(rs.getNString(7));
				return e;
			}
		}
	}




//@FunctionalInterface
//interface ServiceManagersUpdate {
//    void update(String sql, Object... args);
//}
//
//public void saveServiceManagers(ServiceManagers serviceManagers) {
//    String sql = "insert into ServiceManagers(ServiceManagerID,Name,Email,Contact,BranchID,role,password) values(?,?,?,?,?,?,?)";
//
//    ServiceManagersUpdate updateFunction = (sqlQuery, args) -> {
//        jdbcTemplate.update(sqlQuery, args);
//    };
//
//    updateFunction.update(sql, serviceManagers.getServiceManagerID(), serviceManagers.getName(),
//            serviceManagers.getEmail(), serviceManagers.getContact(), serviceManagers.getBranchID(),
//            serviceManagers.getRole(), serviceManagers.getPassword());
//}
