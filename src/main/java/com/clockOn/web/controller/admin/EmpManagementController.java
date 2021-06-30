package com.clockOn.web.controller.admin;

import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;
import com.clockOn.web.service.empManagement.*;
import java.io.*;
import java.sql.Date;
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
		List<MemberList> list = memberService.listView();
		model.addAttribute("list", list);
		return "empManagement.empinfo.memberList";
	}
	
	@GetMapping("memberlist")
	public String memberlist(Model model) {
		List<MemberList> list = memberService.listView();
		model.addAttribute("list", list);
		int cnt = memberService.count();
		model.addAttribute("cnt", cnt);
		return "empManagement.empinfo.memberList";
	}
	@GetMapping("leaveInfo")
	public String leaveInfo(Model model) {
		List<MemberLeave> list = memberService.listLeave();
		model.addAttribute("list", list);
		int cnt = memberService.count();
		model.addAttribute("cnt", cnt);
		return "empManagement.empinfo.leaveInfo";
	}
	
	@GetMapping("salaryInfo")
	public String salaryInfo(Model model) {
		List<MemberSal> list = memberService.listSal();
		model.addAttribute("list", list);
		int cnt = memberService.count();
		model.addAttribute("cnt", cnt);
		return "empManagement.empinfo.salaryInfo";
	}
	
	
	@GetMapping("addMember")
	public String addMemer() {
		
		return "empManagement.empinfo.addMember";
	}
	
	@PostMapping("addMember")
	public String addMember(String emp_id, String emp_name, String emp_email, String emp_tel, String emp_dept,
			String emp_posi, @RequestParam(name="emp_level", defaultValue="0") String emp_level, String emp_sal, @RequestParam(name="total_annday", defaultValue="15") int total_annday, MultipartFile emp_pic) throws IllegalStateException, IOException {
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
			System.out.println(realPath);
		}
		
		Member member = new Member(emp_id, "", emp_name, emp_email, emp_tel, emp_dept, emp_posi, emp_level, null, null,	emp_sal, fileName, total_annday, 0);
		int result = memberService.add(member);

		return "empManagement.organization.contacts";
	}

	@GetMapping("corrInfo")
	public String modify(Model model) {
		List<MemberList> list = memberService.listView();
		model.addAttribute("list", list);
		int cnt = memberService.count();
		model.addAttribute("cnt", cnt);
		return "empManagement.empinfo.corrInfo";
	}
	
	@PostMapping("corrInfo")
	public String updateInfo(String org_groupname, String emp_dept, String emp_id, String emp_name, String emp_posi, String emp_tel, String emp_email, 
			String emp_level) {
		MemberList list = new MemberList(org_groupname, emp_dept, emp_id, emp_name, emp_posi, emp_tel, emp_email, emp_level);
		memberService.update(list);
		return "empManagement.empinfo.memberList";
	}

}
