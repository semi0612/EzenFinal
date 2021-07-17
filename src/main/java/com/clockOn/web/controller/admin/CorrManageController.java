package com.clockOn.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.entity.correction.Correction;
import com.clockOn.web.service.correction.CorrectionService;

@Controller
@RequestMapping("/admin/timeCorrManagement/")
public class CorrManageController {
	
	@Autowired
	private CorrectionService correctionService;

	@GetMapping("current")
	public String current() {
		
		return "areqManagement.timeCorr.current";
	}
	
	@GetMapping("all")
	public String all(Model model) {
		
		List<Correction> corrList = correctionService.corrListAll();
		model.addAttribute("corrList", corrList);
		
		return "reqManagement.timeCorr.all";
	}
	
	@PostMapping("all")
	public String corrListAll() {
		
		return "reqManagement.timeCorr.all";
	}
}
