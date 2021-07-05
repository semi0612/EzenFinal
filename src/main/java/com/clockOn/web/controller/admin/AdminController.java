package com.clockOn.web.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.member.Member;

import lombok.Setter;


@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Setter(onMethod_ = { @Autowired })
	private MemberDAO memberMapper;
	
	@GetMapping("main")
	public String admin_main(Principal principal, HttpSession session) {
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
