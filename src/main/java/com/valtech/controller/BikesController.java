package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.valtech.service.BikeService;
import com.valtech.viewAndModel.BikesVm;

@Controller
public class BikesController {

	@Autowired
	private BikeService bikeService;

	

	// for viewing bike list
	@RequestMapping("/viewBikesList")
	public String viewBikes(Model m) {
		return bikeService.viewBikes(m);
		
	}
	

	@RequestMapping(value = "/deletebike/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		return bikeService.delete(id);
		
	}

	@RequestMapping(value = "serviceManagers/deletebike/{id}", method = RequestMethod.GET)
	public String delete1(@PathVariable int id, @ModelAttribute("bikes") BikesVm bikes) {
		return bikeService.deleteBikeForManager(id,bikes);
		
	}

	@RequestMapping(value = "/editBike/{id}")
	public String edit(@PathVariable int id, Model m) {
		return bikeService.editBike(id,m);
		
	}

	@RequestMapping(value = "serviceManagers/editManager/{id}")
	public String edit1(@PathVariable int id, Model m) {
		return bikeService.editBikeForManager(id,m);
		
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("bikes") BikesVm bikes) {
		return bikeService.editSave(bikes);
		
	}

	
	@RequestMapping(value = "/serviceManagers/editManager/editsave", method = RequestMethod.POST)
	public String editsave1(@ModelAttribute("bikes") BikesVm bikes) {
		return bikeService.editSaveForManager(bikes);
		
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("bikes") BikesVm bikes) {
		return bikeService.save(bikes);
		
	}

	@RequestMapping(value = "/serviceManagers/addManager/saveManager", method = RequestMethod.POST)
	public String save1(@ModelAttribute("bikes") BikesVm bikes) {
		return bikeService.saveBikesForManager(bikes);	
	}
	

	@RequestMapping("/addBikes")
	public String showform(Model m) {
		return bikeService.showForm(m);
		
	}
	

	
	@RequestMapping("serviceManagers/addManager/{serviceManagerId}")
	public String showform2(@PathVariable int serviceManagerId, Model m) {
		return bikeService.showFormForManager(serviceManagerId,m);
		
	}

	
	@RequestMapping("/viewBikes/{serviceManagerId}")
	public String viewBikesUnderServiceManager(@PathVariable int serviceManagerId, Model model) {
		return bikeService.ViewBikesUnderServiceManager(serviceManagerId,model);
		
	}

	
	@RequestMapping("/serviceManagers/{serviceManagerId}")
	public String viewBikesUnderServiceManagers(@PathVariable int serviceManagerId, Model model) {
		return bikeService.viewBikesUnderServiceManagers(serviceManagerId,model);
		
	}
}
