package com.clockOn.web.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.model.MemberDAO;
import com.clockOn.web.model.MemberDTO;

@Controller
@RequestMapping("/admin/empManagement/")  //localhost:8090/admin/empManagement/organization
public class EmpManagementController {
	/*실제 요청명/admin/empManagement/organization*/
	/*서블릿으로 넘어가는 주소? /empManagement.organization.list*/

	@RequestMapping("organization")
	public String organization() {
		return "empManagement.organization.list";
	}
	
	@RequestMapping("contacts")
	public String contacts() {
		return "empManagement.organization.contacts";
	}
	
	@RequestMapping("addMember")
	public String addMember() {
		return "empManagement.empinfo.addMember";
	}
	@RequestMapping("modify")
	public String modify() {
		return "empManagement.empinfo.modify";
	}
	
	/*
	@Inject
	MemberDAO memberDao;
	
	@RequestMapping("member/list")
	public String list(Model model) {
		List<MemberDTO> list = memberDao.list();
		model.addAttribute("list",list);
		return "member/list";
	}
	*/
}
