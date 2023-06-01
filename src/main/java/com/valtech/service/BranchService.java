package com.valtech.service;

import org.springframework.ui.Model;

import com.valtech.model.Branches;

public interface BranchService {

	

	String listOfBranches(Model model);

	String deleteBranch(int id);

	String edit(int id, Model m);

	String editSave(Branches branches);

	String save(Branches branches);

	String showForm(Model m);

}