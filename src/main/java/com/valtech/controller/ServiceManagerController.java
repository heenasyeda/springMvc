package com.valtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.dao.BikesDAO;
import com.valtech.dao.ServiceManagersDAO;
import com.valtech.model.Bikes;
import com.valtech.model.ServiceManagers;



@Controller
public class ServiceManagerController {
	
	@Autowired
	ServiceManagersDAO serviceManagersDAO;
	
	@Autowired
	BikesDAO bikesDAO;
	
	   //for viewing servicemanager list
		@RequestMapping("/viewService")
		public String viewServiceManager(Model m) {
			List<ServiceManagers> list = serviceManagersDAO.getAllServiceManager();
			m.addAttribute("list", list);
			return "viewService";

		}
		
		@RequestMapping(value = "/deleteService/{id}", method = RequestMethod.GET)
		public String delete(@PathVariable int id) {
			serviceManagersDAO.deleteServiceManagers(id);
			return "redirect:/viewService";

		}
		@RequestMapping(value = "/editService/{id}")
		public String edit(@PathVariable int id, Model m) {
			ServiceManagers serviceManagers= serviceManagersDAO.getServiceManagerById(id);
			m.addAttribute("command", serviceManagers);
			return "editService";

		}
		
		    @RequestMapping(value ="/editsaveService",method = RequestMethod.POST)
		    public String editsave(@ModelAttribute("serviceManagers") ServiceManagers serviceManagers){
		  serviceManagersDAO.updateServiceManagerateBike(serviceManagers);
		    return "redirect:/viewService";

		    }

		 
	    @RequestMapping(value="/saveService",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("serviceManagers") ServiceManagers serviceManagers){  		 	
	        serviceManagersDAO.addService(serviceManagers);	       
	        return "redirect:/viewService";//will redirect to view bike request mapping    
	    }  
	    
	    @RequestMapping("/addService")    
	    public String showform(Model m){    
	        m.addAttribute("command", new ServiceManagers());  
	        return "addService";   
	    }  
	    

	   
}
