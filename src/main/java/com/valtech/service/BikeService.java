package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.viewAndModel.BikesVm;

public interface BikeService {


	String viewBikes(Model m);

	String delete(int id);

	String editBike(int id, Model m);

	String editBikeForManager(int id, Model m);

	String editSave(BikesVm bikes);

	String editSaveForManager(BikesVm bikes);

	String save(BikesVm bikes);

	String saveBikesForManager(BikesVm bikes);

	String showForm(Model m);

	String showFormForManager(int serviceManagerId, Model m);

	String ViewBikesUnderServiceManager(int serviceManagerId, Model model);

	String viewBikesUnderServiceManagers(int serviceManagerId, Model model);

	String deleteBikeForManager(int id, BikesVm bikes);
}