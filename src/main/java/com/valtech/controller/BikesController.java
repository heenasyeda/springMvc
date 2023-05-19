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
		try {
		List<Bikes> list = bikesDAO.getAllBikes();
		m.addAttribute("list", list);
		return "viewBikesList";
	}catch(Exception e){
        return "error";
	}
  }

	@RequestMapping(value = "/deletebike/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		try {
		bikesDAO.deleteBike(id);
		return "redirect:/viewBikesList";
	}catch(Exception e){
        return "error";
	}
  }
	

	@RequestMapping(value = "serviceManagers/deletebike/{id}", method = RequestMethod.GET)
	public String delete1(@PathVariable int id,@ModelAttribute("bikes") Bikes bikes) {
		try {
		Bikes b= bikesDAO.getBikeById(id);
		bikesDAO.deleteBike(id);
		return "redirect:/serviceManagers/" +b.getServiceManagerID();
	}catch(Exception e){
        return "error";
	}
  }

	
	@RequestMapping(value = "/editBike/{id}")
	public String edit(@PathVariable int id, Model m) {
		try {
		Bikes bikes= bikesDAO.getBikeById(id);
		m.addAttribute("command", bikes);
		return "editBike";
	}catch(Exception e){
        return "error";
	}
  }
	
	@RequestMapping(value = "serviceManagers/editManager/{id}")
	public String edit1(@PathVariable int id, Model m) {
		try {
		Bikes bikes= bikesDAO.getBikeById(id);
		m.addAttribute("command", bikes);
		return "editManager";

	}catch(Exception e) {
    	return "error";
    }
	}

	
	    @RequestMapping(value ="/editsave",method = RequestMethod.POST)
	    public String editsave(@ModelAttribute("bikes") Bikes bikes){
	    	try {
	    bikesDAO.updateBike(bikes);
	    return "redirect:/viewBikesList";
	    }catch(Exception e) {
	    	return "error";
	    }
	    }
	    
	    @RequestMapping(value ="/serviceManagers/editManager/editsave",method = RequestMethod.POST)
	    public String editsave1(@ModelAttribute("bikes") Bikes bikes){
	    	try {
	    bikesDAO.updateBike(bikes);
	    return "redirect:/serviceManagers/" + bikes.getServiceManagerID();
	    }catch(Exception e) {
	    	return "error";
	    }
	    }
	    
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("bikes") Bikes bikes){  
	    	try {
	        bikesDAO.save(bikes); 	       
	        return "redirect:/viewBikesList";//will redirect to view bike request mapping    
	    }  catch(Exception e) {
	    	return "error";
	    }
	    }
	  
	    @RequestMapping(value = "/serviceManagers/addManager/saveManager", method = RequestMethod.POST)    
	    public String save1(@ModelAttribute("bikes") Bikes bikes) { 
	    	try {
	    	
	        bikesDAO.save(bikes);       
	        return "redirect:/serviceManagers/"+bikes.getServiceManagerID(); 
	    }catch(Exception e) {
	    	return "error";
	    }
	    }
        
	
	    @RequestMapping("/addBikes")    
	    public String showform(Model m){  
	    	try {
	        m.addAttribute("command", new Bikes());  
	        return "addBikes";   
	    }catch(Exception e) {
	    	return "error";
	    }
	    }
    
	    
	    @RequestMapping("serviceManagers/addManager/{serviceManagerId}")    
	    public String showform2(@PathVariable int serviceManagerId, Model m){  
	    	try {
	        m.addAttribute("command", new Bikes());  
	        m.addAttribute("serviceManagerId", serviceManagerId);
	        return "addManager";   
	    }  catch(Exception e) {
	    	return "error";
	    }
	    }
	     
	   
	    @RequestMapping("/viewBikes/{serviceManagerId}")
	    public String viewBikesUnderServiceManager(@PathVariable int serviceManagerId, Model model) {
	    	try {
	        ServiceManagers serviceManager = serviceManagersDAO.getServiceManagerById(serviceManagerId);		
	        List<Bikes> bikes = bikesDAO.getBikesByServiceManagerId(serviceManagerId);
	        model.addAttribute("serviceManager", serviceManager);
	        model.addAttribute("bikes", bikes);
	        return "viewBikes";
	    }catch(Exception e){
	          return "error";
	    }
	    }

	    @RequestMapping("/serviceManagers/{serviceManagerId}")
	    public String viewBikesUnderServiceManagers(@PathVariable int serviceManagerId, Model model) {
	    	try {
	        ServiceManagers serviceManager = serviceManagersDAO.getServiceManagerById(serviceManagerId);		
	        List<Bikes> bikes = bikesDAO.getBikesByServiceManagerId(serviceManagerId);
	        model.addAttribute("serviceManager", serviceManager);
	        model.addAttribute("serviceManagerId", serviceManagerId);
	        model.addAttribute("bikes", bikes);
	        return "serviceManagers";
	    	}
	    	
	    	catch(Exception e){
	          return "error";
	    	 }
	    }
	    }





	    
