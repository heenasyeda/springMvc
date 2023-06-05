package com.valtech.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.valtech.dao.ServiceManagersDAO;
import com.valtech.dao.UserDAO;

import com.valtech.model.User;
import com.valtech.viewAndModel.ServiceManagersVm;
import com.valtech.viewAndModel.UserVm;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ServiceManagersDAO serviceManagersDAO;


	@Override
	public String loginUser(User user, ServiceManagersVm serviceManagers, BindingResult result, ModelMap model,
			HttpSession session) {
		String userEmail = user.getEmail();
		String userPassword = user.getPassword();
		String serviceManagerEmail = serviceManagers.getEmail();
		String serviceManagerPassword = serviceManagers.getPassword();
		try {
		ServiceManagersVm serviceManager = serviceManagersDAO.getByEmail(serviceManagerEmail);
		if (serviceManager != null && serviceManager.getPassword().equals(serviceManagerPassword)) {
		session.setAttribute("serviceManagers", serviceManager);
		if (serviceManager.getRole().equals("manager")) {
		return "redirect:/serviceManagers/" + serviceManager.getServiceManagerID();
		} else {
		model.addAttribute("error", "Invalid Email or Password");
		return "login";
		}
		} else {
		UserVm loggedInUser = userDAO.findByEmail(userEmail);
		if (loggedInUser != null && ("admin").equals(userPassword)) {
		session.setAttribute("user", loggedInUser);
		if (loggedInUser.getRole().equals("admin")) {
		return "redirect:/viewService";
		} else {
		model.addAttribute("error", "Invalid Email or Password");
		return "login";
		}
		} else {
		throw new EmptyResultDataAccessException(1);
		}
		}
		} catch (EmptyResultDataAccessException e) {
		model.addAttribute("error", "Invalid Email or Password");
		return "login";
		}	 
	}


	@Override
	public String Login(Model model) {
		 model.addAttribute("User", "user");
		    return "login";
	}
}
