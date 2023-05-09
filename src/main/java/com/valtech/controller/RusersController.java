package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.dao.RusersDAO;
import com.valtech.model.Rusers;

@Controller
public class RusersController {

	@Autowired
	RusersDAO rusersDAO;
	
	@RequestMapping("saveUsers")
	@ResponseBody
	public String saveUsers() {
		Rusers rusers= new Rusers();
		rusers.setName("admin");
		rusers.setEmail("admin@gmail.com");
		rusers.setPassword("Password");
		rusers.setRole("admin");
		rusersDAO.saveUser(rusers);
		return " user name is "+ rusers.getName();
		
	}
}


