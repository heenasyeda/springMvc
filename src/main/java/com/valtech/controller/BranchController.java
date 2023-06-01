package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.model.Branches;
import com.valtech.service.BranchService;

@Controller
public class BranchController {

	@Autowired
	BranchService branchService;

	@RequestMapping("/list")
	public String listBranches(Model model) {
		return branchService.listOfBranches(model);
		
	}

	@RequestMapping(value = "/deletebranch/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		return branchService.deleteBranch(id);
		

	}

	@RequestMapping(value = "/editbranch/{id}")
	public String edit(@PathVariable int id, Model m) {
		return branchService.edit(id,m);
     }

	@RequestMapping(value = "/editsavebranch", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("branches") Branches branches) {
		return branchService.editSave(branches);
			
	}

	@RequestMapping(value = "/savebranch", method = RequestMethod.POST)
	public String save(@ModelAttribute("branches") Branches branches) {
		return branchService.save(branches);
			
	}
		

	@RequestMapping("/addbranch")
	public String showform(Model m) {
		return branchService.showForm(m);
		
	}

}
