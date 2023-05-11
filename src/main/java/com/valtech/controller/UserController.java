package com.valtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.dao.UserDAO;
import com.valtech.model.User;

@Controller
public class UserController {
	
	    @Autowired
	    private UserDAO userDAO;

	    // list of user manager
	    @RequestMapping("/UserList")
	    public String getAllUsers(Model m) {
	        List<User> list = userDAO.getUsers();
	        m.addAttribute("list", list);
	        return "UserList";
	    }

	    

	      @RequestMapping("/addUser")  
	        public String showform(Model m){  
	            m.addAttribute("command", new User());
	            return "addUser"; 
	        }
	      
	      // deleteing the user manager
	      @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	      public String delete(@PathVariable int id) {
	          userDAO.deleteUser(id);
	          return "redirect:/UserList";
	      }

	       
	      @RequestMapping(value = "/edituser/{id}")
	      public String edit(@PathVariable int id, Model m) {
	          User user = userDAO.getUserbyId(id);
	          m.addAttribute("command", user);
	          return "edituser";
	      }

	      @RequestMapping(value = "/editsaveuser", method = RequestMethod.POST)
	      public String editsave(@ModelAttribute("user") User user) {
	          userDAO.updateUser(user);
	          return "redirect:/UserList";
	      }
	      
	      

	      

	      @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	      public String save(@ModelAttribute("user") User user) {
	          userDAO.createUser(user);
	          return "redirect:/UserList";// will redirect to viewemp request mapping

	      }
	     
	  	
}
