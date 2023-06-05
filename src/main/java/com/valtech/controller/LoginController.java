package com.valtech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.model.User;
import com.valtech.service.LoginService;
import com.valtech.viewAndModel.ServiceManagersVm;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String Login(Model model) {
	   return loginService.Login(model);
	 }
	 
	 
	 @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	 public String loginUser(@Validated @ModelAttribute("user") User user, @ModelAttribute("serviceManagers") ServiceManagersVm serviceManagers,BindingResult result,ModelMap model,HttpSession session) {
	   return loginService.loginUser(user,serviceManagers,result,model,session);
}
}