package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.valtech.service.UserService;
import com.valtech.viewAndModel.UserVm;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// list of user
	@RequestMapping("/UserList")
	public String getAllUsers(Model m) {
		return userService.getAllUsers(m);
	}

	@RequestMapping("/addUser")
	public String showform(Model m) {
		return userService.showSorm(m);
	}

	// deleting the user
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		return userService.delete(id);
	}

	@RequestMapping(value = "/edituser/{id}")
	public String edit(@PathVariable int id, Model m) {
		return userService.edit(id,m);
	}

	@RequestMapping(value = "/editsaveuser", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") UserVm user) {
		return userService.editSave(user);
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") UserVm user) {
	return userService.save(user);

	}

}
