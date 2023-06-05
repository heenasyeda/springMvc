package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.viewAndModel.BranchesVm;

public interface BranchService {

	

	String listOfBranches(Model model);

	String deleteBranch(int id);

	String edit(int id, Model m);

	String editSave(BranchesVm branches);

	String save(BranchesVm branches);

	String showForm(Model m);

}