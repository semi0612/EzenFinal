package com.clockOn.web.controller.admin;

import com.clockOn.web.entity.Member;
import com.clockOn.web.service.empManagement.*;
import java.io.*;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/empManagement/")
public class EmpManagementController {
	@Autowired
	private ServletContext ctx;
//	@Autowired
	private OrganizationService orgService;
	@Autowired
	private MemberService memberService;
//	@Autowired
	private AttendanceService attendanceService;

	@GetMapping("organization")
	public String organization() {
		return "empManagement.organization.list";
	}

	@GetMapping("contacts")
	public String contacts() {
		return "empManagement.organization.contacts";
	}

	@PostMapping("memberlist")
	public String list(Model model) {
		List<Member> list = memberService.list();
		model.addAttribute("list", list);
		return "empManagement.empinfo.memberList";
	}
	
	@PostMapping("addMember")
	public String addMember(String emp_id, String emp_name, String emp_email, String emp_tel, String emp_dept,
			String emp_posi, String emp_level, String emp_sal, @RequestParam("total_annday") int total_annday, MultipartFile emp_pic) throws IllegalStateException, IOException {
		
		long size = emp_pic.getSize();
		String fileName = emp_pic.getOriginalFilename();
		if (fileName != null) {
			String webPath = "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			File savePath = new File(realPath);
			if (!savePath.exists())
				savePath.mkdirs();
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			emp_pic.transferTo(saveFile);
		}
		
		Member member = new Member(emp_id, "", emp_name, emp_email, emp_tel, emp_dept, emp_posi, emp_level, null, null,	emp_sal, fileName, total_annday, 0);
		int result = memberService.add(member);

		return "empManagement.empinfo.addMember";
	}

	@GetMapping("modify")
	public String modify() {
		return "empManagement.empinfo.modify";
	}

}
