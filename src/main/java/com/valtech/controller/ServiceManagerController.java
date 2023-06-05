package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.valtech.service.ServiceManager;
import com.valtech.viewAndModel.ServiceManagersVm;

@Controller
public class ServiceManagerController {
	
	
	@Autowired
	ServiceManager serviceManager;

	// for viewing servicemanager list
	@RequestMapping("/viewService")
	public String viewServiceManager(Model m) {
		return serviceManager.viewServiceManager(m);
		
	}
	
	@RequestMapping("/ascending")
	public String viewServiceManagerByAcending(Model m) {
		return serviceManager.viewServiceManagerByAcending(m);
		
	}
	@RequestMapping("/decending")
	public String viewServiceManagerByDecending(Model m) {
		return serviceManager.viewServiceManagerByDecending(m);
		
	}
	
	
	@RequestMapping(value = "/deleteService/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		return serviceManager.deleteManager(id);
	
	}

	@RequestMapping(value = "/editService/{id}")
	public String edit(@PathVariable int id, Model m) {
		return serviceManager.editManager(id,m);
		
	}

	@RequestMapping(value = "/editsaveService", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("serviceManagers") ServiceManagersVm serviceManagers) {
		return serviceManager.editSaveForManager(serviceManagers);		
	}

	@RequestMapping(value = "/saveService", method = RequestMethod.POST)
	public String save(@ModelAttribute("serviceManagers") ServiceManagersVm serviceManagers) {
		return serviceManager.save(serviceManagers);
	
	}


	@RequestMapping("/addService")
	public String showform(Model m) {
		return serviceManager.showForm(m);
	}

	

	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "searchOption", required = false) String searchOption,
                         @RequestParam(value = "searchCriteria", required = false) String searchCriteria,
                         Model model) {
       return serviceManager.search(searchOption,searchCriteria,model);
    }

}
