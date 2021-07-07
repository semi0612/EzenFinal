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
import com.clockOn.web.service.empManagement.MemberService;

import lombok.Setter;


@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@Setter(onMethod_ = { @Autowired })
	private MemberDAO memberMapper;
	
	@GetMapping("main")
	public String admin_main(Principal principal, HttpSession session, Model model) {
		
		model.addAttribute("memberCount", memberService.count());
		
		if(session.getAttribute("level")==null) {
			String username = principal.getName();
			Member member= memberMapper.read(username);
	        session.setAttribute("level", member.getEmp_level());
	        session.setAttribute("id", member.getEmp_id());
	        session.setAttribute("name", member.getEmp_name());
		}
		
		return "admin.main";
	}

}
