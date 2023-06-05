package com.valtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.valtech.dao.RevenueDAO;
import com.valtech.viewAndModel.RevenueVm;


@Service
public class RevenueServiceImpl implements RevenueService  {

	
	@Autowired
	RevenueDAO revenueDAO;

	@Override
	public String viewRevenueService(Model m) {
		try {
			List<RevenueVm> list = revenueDAO.getAllRevenue();
			m.addAttribute("list", list);
			return "viewRevenue";
		}catch(Exception e){
	        return "error";
		}
	}

	@Override
	public String addRevenues(RevenueVm revenue) {
		try {
			revenueDAO.saveRevenue(revenue);
			return "redirect:/serviceManagers/viewRevenue";
		}catch(Exception e){
	        return "error";
		}
	}

	@Override
	public String ShowForm(int serviceManagerId, Model m) {
		 try {
		        m.addAttribute("command", new RevenueVm());
		        m.addAttribute("serviceManagerId", serviceManagerId);
		        
		        return "addRevenue";   
		    }catch(Exception e){
		        return "error";
			}
	}

	@Override
	public String viewRevenue(Model model) {
		try {
			
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
		}catch(Exception e){
	        return "error";
		}
	
}
}