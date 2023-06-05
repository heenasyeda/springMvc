package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valtech.service.RevenueService;
import com.valtech.viewAndModel.RevenueVm;


@Controller
public class RevenueController {
	
	@Autowired
	RevenueService revenueService;
	
	
		
	@RequestMapping("/serviceManagers/viewRevenue")
	public String viewServiceManager(Model m) {
		return revenueService.viewRevenueService(m);			
  }
	
	@RequestMapping("/serviceManagers/saveRevenue")
	public String addRevenue(@ModelAttribute("revenue") RevenueVm revenue) {
		return revenueService.addRevenues(revenue);
		
  }
	
	  @RequestMapping("/serviceManagers/addRevenue/{serviceManagerId}")    
	    public String showform(@PathVariable("revenueService") int serviceManagerId,Model m){ 
		  return revenueService.ShowForm(serviceManagerId,m);
	  }
	    
	
	
	@RequestMapping("/revenue")
	public String viewRevenue(Model model) {
		return revenueService.viewRevenue(model);
  }


}
