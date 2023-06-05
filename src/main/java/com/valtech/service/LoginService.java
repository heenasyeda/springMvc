package com.valtech.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;


import com.valtech.model.User;
import com.valtech.viewAndModel.ServiceManagersVm;

public interface LoginService {



	String Login(Model model);

	String loginUser(User user, ServiceManagersVm serviceManagers, BindingResult result, ModelMap model,
			HttpSession session);

}