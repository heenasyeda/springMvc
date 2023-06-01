package com.valtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.valtech.dao.BranchesDAO;
import com.valtech.model.Branches;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	BranchesDAO branchesDAO;

	@Override
	public String listOfBranches(Model model) {
		model.addAttribute("branches", branchesDAO.getAllBranches());
		return "branch-list";
	}

	@Override
	public String deleteBranch(int id) {
		branchesDAO.deleteBranches(id);
		return "redirect:/list";
	}

	@Override
	public String edit(int id, Model m) {
		Branches branches = branchesDAO.getBranchesById(id);
		m.addAttribute("command", branches);
		return "editbranch";

	}

	@Override
	public String editSave(Branches branches) {
		branchesDAO.updateBranches(branches);
		return "redirect:/list";

	}

	@Override
	public String save(Branches branches) {
		branchesDAO.addBranches(branches);
		return "redirect:/list";// will redirect to view branch request mapping
	}

	@Override
	public String showForm(Model m) {
		m.addAttribute("command", new Branches());
		return "addbranch";
	}
	
	
	
}


