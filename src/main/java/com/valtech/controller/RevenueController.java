package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.dao.RevenueDAO;
import com.valtech.model.Revenue;


@Controller
public class RevenueController {
	
	@Autowired
	RevenueDAO revenueDAO;
	
	@RequestMapping("saveRevenue")
	@ResponseBody
	public String saveRevenue() {
		Revenue revenue= new Revenue();
		revenue.setBranchID(1);	
		revenue.setTimePeriod("1 year");
		revenueDAO.saveRevenue(revenue);
		return "revenue id is  "+ revenue.getBranchID();
		
	
		
	}

}
