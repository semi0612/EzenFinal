package com.clockOn.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clockOn.web.service.empManagement.MemberService;

@Controller
@RequestMapping("/admin/timeRecord/")
// @RestController("/admin/timeRecord/")
public class TimeRecordController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("byCalendar")
	public String organization() {
		return "timeRecord.byCalendar";
	}
	
	@GetMapping("byList")
	public String allByList(Model model) {
		model.addAttribute("cnt", memberService.count());
		return "timeRecord.byList";
	}
}
