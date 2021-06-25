package com.clockOn.web.controller.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/") //localhost ~ /emp/login_emp
public class EmpController {
	
	@RequestMapping("login_emp")
	public String login_emp() {
		return "/emp/login_emp";
	}
	
	/*
	 * public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView("/login_emp");
	 * //mv.setViewName("/WEB-INF/view/notice/list.jsp");
	 * 
	 * return mv; }
	 */

}
