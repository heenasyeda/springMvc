package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.dao.ServiceManagersDAO;
import com.valtech.model.ServiceManagers;



@Controller
public class ServiceManagerController {
	
	@Autowired
	ServiceManagersDAO serviceManagersDAO;
	
	
	@RequestMapping("saveServiceManager")
	@ResponseBody
	public String saveServiceManager() {
		ServiceManagers serviceManagers = new ServiceManagers();
		serviceManagers.setBranchID(1);
		serviceManagers.setEmail("abh@gmail.com");
		serviceManagers.setContact("9865874589");
		serviceManagers.setName("shd");
		serviceManagersDAO.saveService(serviceManagers);
		return "service manager name is " + serviceManagers.getName();
		
		
		
		
	}
	

}
