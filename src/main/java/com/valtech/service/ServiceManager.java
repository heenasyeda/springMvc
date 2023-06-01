package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.model.ServiceManagers;

public interface ServiceManager {

	String viewServiceManager(Model m);

	String deleteManager(int id);

	String editManager(int id, Model m);

	String editSaveForManager(ServiceManagers serviceManagers);

	String save(ServiceManagers serviceManagers);

	String showForm(Model m);

	String search(String searchOption, String searchCriteria, Model model);


	String viewServiceManagerByAcending(Model m);

	String viewServiceManagerByDecending(Model m);



	
}