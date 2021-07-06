package com.clockOn.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@GetMapping("current")
	public String vcCurrList(Model model){
		List<VacationInfo> vac = vacationService.listWaitReq();
		model.addAttribute("vacList", vac);
		model.addAttribute("cnt", vacationService.cntReq());
		return "reqManagement.vacation.current";
	}
	
	@PostMapping("confirm")
	public void confirmReq(String id, String holi_code, String holi_period, String emp_id, HttpServletResponse response) throws IOException {
		String[] off = holi_period.split(" / ");
		String last = off[off.length-1];
		off[off.length-1] = last.substring(0, 8); //날짜별로 쪼개서 배열에 저장
		
		vacationService.confirm(id, emp_id, holi_code, off, holi_period);
		
		response.sendRedirect("all");
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
