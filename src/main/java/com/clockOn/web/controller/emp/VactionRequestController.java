package com.clockOn.web.controller.emp;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/vacation/")
public class VactionRequestController {
	@Autowired
	private ServletContext ctx;
	
	//요청 페이지
	@GetMapping("request")
	public String vacReq() {
		
		
		return "emp.vacation.vcRequest";
	}
	
	//요청 페이지 입력 처리
	@PostMapping("request")
	public String sendReq() {
		
		
		return "emp.vacation.vcList";
	}
	
	@GetMapping
	public String vacReqlist() {
		
		return "emp.vacation.vcList";
	}

}
