package com.valtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class BikesController {

	@Autowired
	BikesDAO bikesDAO;
	
	
	@Autowired
	 private ServiceManagersDAO serviceManagersDAO;

	//for viewing bike list
	@RequestMapping("/viewBikesList")
	public String viewBikes(Model m) {
		List<Bikes> list = bikesDAO.getAllBikes();
		m.addAttribute("list", list);
		return "viewBikesList";

	}

	@RequestMapping(value = "/deletebike/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		bikesDAO.deleteBike(id);
		return "redirect:/viewBikesList";

	}

	
	@RequestMapping(value = "/editBike/{id}")
	public String edit(@PathVariable int id, Model m) {
		Bikes bikes= bikesDAO.getBikeById(id);
		m.addAttribute("command", bikes);
		return "editBike";

	}
	
	    @RequestMapping(value ="/editsave",method = RequestMethod.POST)
	    public String editsave(@ModelAttribute("bikes") Bikes bikes){
	    bikesDAO.updateBike(bikes);
	    return "redirect:/viewBikesList";

	    }
	    
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("bikes") Bikes bikes){  		 	
	        bikesDAO.save(bikes); 	       
	        return "redirect:/viewBikesList";//will redirect to view bike request mapping    
	    }   
	 
	
	    @RequestMapping("/addBikes")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Bikes());  
	        return "addBikes";   
	    }    
	   
	    @RequestMapping("/viewBikes/{serviceManagerId}")
	    public String viewBikesUnderServiceManager(@PathVariable int serviceManagerId, Model model) {
	        ServiceManagers serviceManager = serviceManagersDAO.getServiceManagerById(serviceManagerId);		
	        List<Bikes> bikes = bikesDAO.getBikesByServiceManagerId(serviceManagerId);
	        model.addAttribute("serviceManager", serviceManager);
	        model.addAttribute("bikes", bikes);
	        return "viewBikes";
	    }
	


	   


}
