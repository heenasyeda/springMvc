package com.valtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.valtech.dao.ServiceManagersDAO;
import com.valtech.model.ServiceManagers;

@Service
public class ServiceManagerImpl implements ServiceManager {
	
	@Autowired
	ServiceManagersDAO serviceManagersDAO;

	@Override
	public String viewServiceManager(Model m) {
		try {
			List<ServiceManagers> list = serviceManagersDAO.getAllServiceManager();
			m.addAttribute("list", list);
			return "viewService";
		} catch (Exception e) {
			return "error";
		}
	}
	

	

	
	@Override
	public String viewServiceManagerByAcending(Model m) {
		
			List<ServiceManagers> list = serviceManagersDAO.getAllServiceManagerInAscending();
			m.addAttribute("list", list);
			return "viewService";
		
	}
	
	@Override
	public String viewServiceManagerByDecending(Model m) {
		try {
			List<ServiceManagers> list = serviceManagersDAO.getAllServiceManagerInDecending();
			m.addAttribute("list", list);
			return "viewService";
		} catch (Exception e) {
			return "error";
		}
	}

	@Override
	public String deleteManager(int id) {
		try {
			serviceManagersDAO.deleteServiceManagers(id);
			return "redirect:/viewService";
		} catch (Exception e) {
			return "error";
		}
	
}

	@Override
	public String editManager(int id, Model m) {
		try {
			ServiceManagers serviceManagers = serviceManagersDAO.getServiceManagerById(id);
			m.addAttribute("command", serviceManagers);
			return "editService";
		} catch (Exception e) {
			return "error";
		}
	}

	@Override
	public String editSaveForManager(ServiceManagers serviceManagers) {
		try {
			serviceManagersDAO.updateServiceManagerateBike(serviceManagers);
			//serviceManagersDAO.updateServiceManager(serviceManagers);
			return "redirect:/viewService";
		} catch (Exception e) {
			return "error";
		}
	}

	@Override
	public String save(ServiceManagers serviceManagers) {
		try {
			serviceManagersDAO.addService(serviceManagers);
			return "redirect:/viewService";// will redirect to view bike request mapping
		} catch (Exception e) {
			return "error";
		}
	}

	@Override
	public String showForm(Model m) {
		try {
			m.addAttribute("command", new ServiceManagers());
			return "addService";
		} catch (Exception e) {
			return "error";
		}
	}
	

	

		

	@Override
	public String search(String searchOption, String searchCriteria, Model model) {
		 try {
	            if (searchOption != null && searchCriteria != null) {
	                if (searchOption.equals("ServiceManagerId")) {
	                    int ServiceManagerId = Integer.parseInt(searchCriteria);
	                    ServiceManagers serviceManagers= serviceManagersDAO.getServiceManagerById(ServiceManagerId);
	                    model.addAttribute("serviceManagers", serviceManagers);
	                    return "ManagerName";
	                } else if (searchOption.equals("Name")) {
	                	ServiceManagers serviceManagers = serviceManagersDAO.getManagerByName(searchCriteria);
	                    model.addAttribute("serviceManagers", serviceManagers);
	                    return "ManagerName";
	                }

	            }
	            model.addAttribute("error", "Invalid search option");
	            return "error";
	        } catch (Exception e) {
	            return "error";
	        }
	}
	}

	
	

