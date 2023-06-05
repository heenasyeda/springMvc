package com.valtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.valtech.dao.UserDAO;
import com.valtech.viewAndModel.UserVm;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public String getAllUsers(Model m) {
		  List<UserVm> list = userDAO.getUsers();
	        m.addAttribute("list", list);
	        return "UserList";
	}

	@Override
	public String showSorm(Model m) {
		 m.addAttribute("command", new UserVm());
         return "addUser"; 
	}

	@Override
	public String delete(int id) {
		userDAO.deleteUser(id);
		return "redirect:/UserList";
	}

	@Override
	public String edit(int id, Model m) {
		UserVm user = userDAO.getUserbyId(id);
		m.addAttribute("command", user);
		return "edituser";
	}

	@Override
	public String editSave(UserVm user) {
		userDAO.updateUser(user);
		return "redirect:/UserList";
	}

	@Override
	public String save(UserVm user) {
		// TODO Auto-generated method stub
		return null;
	}

}
