package com.valtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valtech.dao.RevenueDAO;
import com.valtech.model.Bikes;
import com.valtech.model.Revenue;


@Controller

public class RevenueController {
	
	@Autowired
	RevenueDAO revenueDAO;
	
	
		
	@RequestMapping("/serviceManagers/viewRevenue")
	public String viewServiceManager(Model m) {
		List<Revenue> list = revenueDAO.getAllRevenue();
		m.addAttribute("list", list);
		return "viewRevenue";

	}
	
	@RequestMapping("/serviceManagers/saveRevenue")
	public String addRevenue(@ModelAttribute("revenue") Revenue revenue) {
		revenueDAO.saveRevenue(revenue);
		return "redirect:/serviceManagers/viewRevenue";
	}
	
	  @RequestMapping("/serviceManagers/addRevenue")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Revenue());  
	        return "addRevenue";   
	    }
	    

	
	@RequestMapping("/revenue")
	public String viewRevenue(Model model) {
		
		// Get revenue by branch
		List<Object[]> revenueByBranch = revenueDAO.getRevenueByBranch();
		model.addAttribute("revenueByBranch", revenueByBranch);
		
		// Get total revenue
		int totalRevenue = revenueDAO.getTotalRevenue();
		model.addAttribute("totalRevenue", totalRevenue);
		
		// Get revenue by service manager
		List<Object[]> revenueByServiceManager = revenueDAO.getRevenueByServiceManager();
		model.addAttribute("revenueByServiceManager", revenueByServiceManager);
		
		return "revenue";
	}


}
