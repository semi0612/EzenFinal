package com.clockOn.web.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clockOn.web.service.empManagement.MemberService;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
public class RootController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/index")
	public void loginInput(String error, String logout, Model model) {

		log.info("error: " + error);
		log.info("logout: " + logout);

		if(error != null) {
			model.addAttribute("error", "사번과 비밀번호를 확인해주세요.");
			model.addAttribute("url", "/index");

		}
	
		
	}	
		
	@GetMapping("/empProfile")
	public String empProfile(String emp_id, Model model) {
		
		model.addAttribute("profile", memberService.profile(emp_id));
		System.out.println(emp_id +"dsadasd");
		return "root.emp.profile";
		

	}
	
	@GetMapping("/adminProfile")
	public String adminProfile(String emp_id, Model model) {
		
		model.addAttribute("profile", memberService.profile(emp_id));
		System.out.println(emp_id +"dsadasd");
		return "root.admin.profile";
		

	}
	
	@GetMapping("/logout")
	public void logoutGET() {
		
	}
	
	@PostMapping("/emp/mode")
	public void emp_mode(HttpServletResponse response) throws IOException {
		session.setAttribute("status", "emp_mode");
		response.sendRedirect("/emp/main");
		
	}
	
	@PostMapping("/admin/mode")
	public void admin_mode(HttpServletResponse response) throws IOException {
		session.setAttribute("status", "admin_mode");
		response.sendRedirect("/admin/main");
		
	}
	
	
}


