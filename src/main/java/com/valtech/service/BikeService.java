package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.model.Bikes;

public interface BikeService {


	String viewBikes(Model m);

	String delete(int id);

	String deleteBikeForManager(int id, Bikes bikes);

	String editBike(int id, Model m);

	String editBikeForManager(int id, Model m);

	String editSave(Bikes bikes);

	String editSaveForManager(Bikes bikes);

	String save(Bikes bikes);

	String saveBikesForManager(Bikes bikes);

	String showForm(Model m);

	String showFormForManager(int serviceManagerId, Model m);

	String ViewBikesUnderServiceManager(int serviceManagerId, Model model);

	String viewBikesUnderServiceManagers(int serviceManagerId, Model model);
}