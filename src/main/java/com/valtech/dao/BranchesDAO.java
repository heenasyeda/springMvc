package com.valtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valtech.model.Branches;



@Repository
public class BranchesDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private class BranchesMapper implements RowMapper<Branches> {
	    public Branches mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Branches branches = new Branches();
	        branches.setBranchID(rs.getInt("BranchID"));
	        branches.setName(rs.getString("Name"));
	        branches.setAddress(rs.getString("Address"));
	        branches.setContact(rs.getString("Contact"));
	        return branches;
	    }
	}
	public void addBranches(Branches branches) {
	    String sql = "INSERT INTO Branches (BranchID, Name, Address, Contact) values (?, ?, ?, ?)";
	    jdbcTemplate.update(sql, branches.getBranchID(), branches.getName(), branches.getAddress(), branches.getContact());
	}
	public Branches getBranchesById(int branchID) {
	    String sql = "SELECT * FROM Branches WHERE BranchID = ?";
	    return jdbcTemplate.queryForObject(sql, new Object[]{branchID}, new BranchesMapper());
	}
	public List<Branches> getAllBranches() {
	    String sql = "SELECT * FROM Branches";
	    return jdbcTemplate.query(sql, new BranchesMapper());
	}
	public void updateBranches(Branches branches) {
		System.out.println(branches);
	    String sql = "UPDATE Branches SET Name = ?, Address = ?, Contact = ? WHERE BranchID = ?";
	    jdbcTemplate.update(sql, branches.getName(), branches.getAddress(), branches.getContact(), branches.getBranchID());
	}
	public void deleteBranches(int branchID) {
	    String sql = "DELETE FROM Branches WHERE BranchID = ?";
	    jdbcTemplate.update(sql, branchID);
	}

}
