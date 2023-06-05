package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.model.User;
import com.valtech.viewAndModel.UserVm;

public interface UserService {

	String getAllUsers(Model m);

	String showSorm(Model m);

	String delete(int id);

	String edit(int id, Model m);

	String editSave(UserVm user);

	String save(UserVm user);

}