package com.valtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.valtech.dao.BikesDAO;
import com.valtech.dao.ServiceManagersDAO;
import com.valtech.viewAndModel.BikesVm;
import com.valtech.viewAndModel.ServiceManagersVm;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	private BikesDAO bikesDAO;
	
	@Autowired
	private ServiceManagersDAO serviceManagersDAO;
	
	

	@Override
	public String viewBikes(Model m) {
		List<BikesVm> list = bikesDAO.getAllBikes();
		m.addAttribute("list", list);
		return "viewBikesList";
	}

	@Override
	public String delete(int id) {
		bikesDAO.deleteBike(id);
		return "redirect:/viewBikesList";
	}

	@Override
	public String deleteBikeForManager(int id, BikesVm bikes) {
		BikesVm b = bikesDAO.getBikeById(id);
		bikesDAO.deleteBike(id);
		return "redirect:/serviceManagers/" + b.getServiceManagerID();
	}

	@Override
	public String editBike(int id, Model m) {
		BikesVm bikes = bikesDAO.getBikeById(id);
		m.addAttribute("command", bikes);
		return "editBike";
	}

	@Override
	public String editBikeForManager(int id, Model m) {
		BikesVm bikes= bikesDAO.getBikeById(id);
		m.addAttribute("command", bikes);
		return "editManager";
	}

	@Override
	public String editSave(BikesVm bikes) {
		bikesDAO.updateBike(bikes);
		return "redirect:/viewBikesList";
	}

	@Override
	public String editSaveForManager(BikesVm bikes) {
		bikesDAO.updateBike(bikes);
		return "redirect:/serviceManagers/" + bikes.getServiceManagerID();
	}

	@Override
	public String save(BikesVm bikes) {
		bikesDAO.save(bikes);
		return "redirect:/viewBikesList";// will redirect to view bike request mapping
	}

	@Override
	public String saveBikesForManager(BikesVm bikes) {
		bikesDAO.save(bikes);
		return "redirect:/serviceManagers/" + bikes.getServiceManagerID();
	}

	@Override
	public String showForm(Model m) {
		m.addAttribute("command", new BikesVm());
		return "addBikes";
	}

	@Override
	public String showFormForManager(int serviceManagerId, Model m) {
		m.addAttribute("command", new BikesVm());
		m.addAttribute("serviceManagerId", serviceManagerId);
		return "addManager";
	}

	@Override
	public String ViewBikesUnderServiceManager(int serviceManagerId, Model model) {
		ServiceManagersVm serviceManagers = serviceManagersDAO.getServiceManagerById(serviceManagerId);
		List<BikesVm> bikes = bikesDAO.getBikesByServiceManagerId(serviceManagerId);
		model.addAttribute("serviceManagers", serviceManagers);
		model.addAttribute("bikes", bikes);
		return "viewBikes";
	}

	@Override
	public String viewBikesUnderServiceManagers(int serviceManagerId, Model model) {
		ServiceManagersVm serviceManagers = serviceManagersDAO.getServiceManagerById(serviceManagerId);
		List<BikesVm> bikes = bikesDAO.getBikesByServiceManagerId(serviceManagerId);
		model.addAttribute("serviceManagers", serviceManagers);
		model.addAttribute("serviceManagerId", serviceManagerId);
		model.addAttribute("bikes", bikes);
		return "serviceManagers";
	}

	

}
