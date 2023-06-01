package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.model.Revenue;

public interface RevenueService {

	String viewRevenueService(Model m);

	String addRevenues(Revenue revenue);

	String ShowForm(int serviceManagerId, Model m);

	String viewRevenue(Model model);

}