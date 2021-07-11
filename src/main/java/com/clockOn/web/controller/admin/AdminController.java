package com.clockOn.web.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.member.Member;
import com.clockOn.web.service.attendance.CommuteService;
import com.clockOn.web.service.empManagement.MemberService;

import lombok.Setter;


@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired 
	private CommuteService commuteService;
	
	@Setter(onMethod_ = { @Autowired })
	private MemberDAO memberMapper;
	
	@GetMapping("main")
	public String admin_main(Principal principal, HttpSession session, Model model) {
		
		model.addAttribute("memberCount", memberService.count());
		model.addAttribute("gowork_count", commuteService.goWorkCount());
		model.addAttribute("notwork_count", commuteService.notWorkCount());
		model.addAttribute("holiday_count", commuteService.holidayCount());
		model.addAttribute("late_count", commuteService.lateCount());
		
		if(session.getAttribute("level")==null || !session.getAttribute("level").equals("ROLE_ADMIN")) {
			String username = principal.getName();
			Member member= memberMapper.read(username);
	        session.setAttribute("level", member.getEmp_level());
	        session.setAttribute("id", member.getEmp_id());
	        session.setAttribute("name", member.getEmp_name());
		}
		
		return "admin.main";
	}

}
