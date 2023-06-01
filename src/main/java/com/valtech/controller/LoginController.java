package com.valtech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.dao.ServiceManagersDAO;
import com.valtech.dao.UserDAO;
import com.valtech.model.ServiceManagers;
import com.valtech.model.User;


@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ServiceManagersDAO serviceManagersDAO;
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("User", "user");
	    return "login";
	 }
	 
	 
	 @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	 public String loginUser(@Validated @ModelAttribute("user") User user,
	                         @ModelAttribute("serviceManagers") ServiceManagers serviceManagers,
	                         BindingResult result,
	                         ModelMap model,
	                         HttpSession session) {
	     String userEmail = user.getEmail();
	     String userPassword = user.getPassword();

	     String serviceManagerEmail = serviceManagers.getEmail();
	     String serviceManagerPassword = serviceManagers.getPassword();

	     try {
	    	    ServiceManagers serviceManager = serviceManagersDAO.getByEmail(serviceManagerEmail);

	    	    if (serviceManager != null && serviceManager.getPassword().equals(serviceManagerPassword)) {
	    	        session.setAttribute("serviceManagers", serviceManager);
	    	        if (serviceManager.getRole().equals("manager")) {
	    	            return "redirect:/serviceManagers/" + serviceManager.getServiceManagerID();
	    	        } else {
	    	            model.addAttribute("error", "Invalid Email or Password");
	    	            return "login";
	    	        }
	    	    } else {
	    	        User loggedInUser = userDAO.findByEmail(userEmail);

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
}
