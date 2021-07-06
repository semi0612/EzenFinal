package com.clockOn.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.entity.vacation.VacationInfo;
import com.clockOn.web.service.vacation.LeaveService;

@Controller
@RequestMapping("/admin/vacManage/")
public class VacManageController {
	@Autowired
	private LeaveService vacationService;
	
	@GetMapping("all")
	public String vcAllList(Model model){
		List<VacationInfo> vac = vacationService.listAllVacReq();
		model.addAttribute("vacList", vac);
		model.addAttribute("cnt", vacationService.cntReq());
		model.addAttribute("cntw", vacationService.cntwReq());
		return "reqManagement.vacation.all";
	}
	
	@GetMapping("waiting")
	public String vcCurrList(Model model){
		List<VacationInfo> vac = vacationService.listWaitReq();
		model.addAttribute("vacList", vac);
		model.addAttribute("cnt", vacationService.cntReq());
		model.addAttribute("cnt", vacationService.cntwReq());
		return "reqManagement.vacation.current";
	}
	
	@GetMapping("confirm")
	public String confirmReq(String id) {
		vacationService.confirm(id);
		return "reqManagement.vacation.all";
	}
	
	@GetMapping("reject")
	public String rejectReq(String id) {
		vacationService.reject(id);
		return "reqManagement.vacation.all";

	}
	
	@GetMapping("cancel")
	public String cancelReq(String id) {
		vacationService.cancel(id);
		return "reqManagement.vacation.all";

	}
	

}
