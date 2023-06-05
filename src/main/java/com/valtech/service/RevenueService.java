package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.viewAndModel.RevenueVm;

public interface RevenueService {

	String viewRevenueService(Model m);

	String addRevenues(RevenueVm revenue);

	String ShowForm(int serviceManagerId, Model m);

	String viewRevenue(Model model); 

}