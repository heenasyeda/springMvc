package com.valtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "login";
	 }

	 @RequestMapping(value ="loginCheck" ,method = RequestMethod.POST)
	  public String submit(Model model, @RequestAttribute String username,@RequestAttribute String password) {
	    if (username != null && password != null) {
	    
	      if (username.equals("admin") && password.equals("admin")) {
	   
	        return "redirect:/UserList";
	      } else {
	        model.addAttribute("error", "Invalid Details");
	        return "login";
	      }
	    } else {
	      model.addAttribute("error", "Please enter Details");
	      return "login";
	    }
	 
	 }}