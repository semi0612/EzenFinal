package com.clockOn.web.controller.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/request/")
public class CorrReqController {
	
	@GetMapping("corrRequest")
	public String corrReq() {
		return "emp.request.corrRequest";
	}
	
	@GetMapping("corrList")
	public String corrList() {
		return "emp.request.corrList";
	}

}
