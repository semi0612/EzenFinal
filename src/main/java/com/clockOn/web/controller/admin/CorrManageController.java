package com.clockOn.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.service.correction.CorrectionService;

@Controller
@RequestMapping("/admin/timeCorrManagement/")
public class CorrManageController {
	
	@Autowired
	private CorrectionService correctionService;

	@GetMapping("current")
	public String current() {
		
		return "reqManagement.timeCorr.current";
	}
	
	@GetMapping("all")
	public String all(Model model) {
		
		model.addAttribute("corrList", correctionService.corrListAll());
		
		return "reqManagement.timeCorr.all";
	}
	
	//@PostMapping("all")
	/*public String corrListAll() {
		
		return "reqManagement.timeCorr.all";
	}*/
}
