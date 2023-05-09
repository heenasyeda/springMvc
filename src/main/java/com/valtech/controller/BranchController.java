package com.valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.dao.BranchesDAO;
import com.valtech.model.Branches;

@Controller
public class BranchController {

	@Autowired
	BranchesDAO branchDAO;

	@RequestMapping("/list")
	public String listBranches(Model model) {
		model.addAttribute("branches", branchDAO.getAllBranches());
		return "branch-list";
	}

	@RequestMapping(value = "/deletebranch/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		branchDAO.deleteBranches(id);
		return "redirect:/list";

	}

	@RequestMapping(value = "/editbranch/{id}")
	public String edit(@PathVariable int id, Model m) {
		Branches branches = branchDAO.getBranchesById(id);
		m.addAttribute("command", branches);
		return "editbranch";

	}

	@RequestMapping(value = "/editsavebranch", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("branches") Branches branches) {
		branchDAO.updateBranches(branches);
		return "redirect:/list";

	}

	@RequestMapping(value = "/savebranch", method = RequestMethod.POST)
	public String save(@ModelAttribute("branches") Branches branches) {
		branchDAO.addBranches(branches);
		return "redirect:/list";// will redirect to view branch request mapping
	}

	@RequestMapping("/addbranch")
	public String showform(Model m) {
		m.addAttribute("command", new Branches());
		return "addbranch";

	}

}
