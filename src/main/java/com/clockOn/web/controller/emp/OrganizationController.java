package com.clockOn.web.controller.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.service.empManagement.MemberService;
import com.clockOn.web.service.empManagement.OrgService;
/*
@Controller
@RequestMapping("/emp/organization/")
public class OrganizationController {
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("organization")
	public String empOrg(Model model) {
		model.addAttribute("orgView", orgService.orgView());
		model.addAttribute("groupcount", orgService.orgCount().get("groupcount"));
		model.addAttribute("teamcount", orgService.orgCount().get("teamcount"));
		
		return "emp.organization.list";
	}
	
	@GetMapping("contacts")
	public String contacts(Model model, String org_teamname) {
		//System.out.println(contactsService.contactsRead(org_teamname).get(0).getEmp_name());
		model.addAttribute("contacts", memberService.contactsRead(org_teamname));
		
		return "emp.organization.contacts";
	}

}*/