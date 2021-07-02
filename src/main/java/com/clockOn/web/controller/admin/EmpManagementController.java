package com.clockOn.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;
import com.clockOn.web.service.empManagement.AttendanceService;
import com.clockOn.web.service.empManagement.MemberService;
import com.clockOn.web.service.empManagement.OrganizationService;

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
	public String addMemer(Model model) {
		List<HashMap<String, String>> org = memberService.listTeam();
		model.addAttribute("orgList", org);
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
		}
		
		Member member = new Member(emp_id, "", emp_name, emp_email, emp_tel, emp_dept, emp_posi, emp_level, null, null,	emp_sal, fileName, total_annday, 0);
		int result = memberService.add(member);

		return "empManagement.organization.memberList";
	}

	@GetMapping("corrInfo")
	public String modify(Model model) {
		List<MemberList> list = memberService.listView();
		model.addAttribute("list", list);
		
		int cnt = memberService.count();
		model.addAttribute("cnt", cnt);
		
		List<String> posiList = memberService.listPosi();
		model.addAttribute("posiList", posiList);
		
		List<HashMap<String, String>> org = memberService.listTeam();
		model.addAttribute("orgList", org);

		return "empManagement.empinfo.corrInfo";
	}
	
	@PostMapping("corrInfo")
	public String updateInfo(String[] emp_id, String[] emp_dept, String[] emp_name, String[] emp_posi, String[] emp_tel, String[] emp_email, String[] emp_level) {
		
		List<MemberList> list = new ArrayList();
		for(int i=0; i<emp_name.length; i++) {
			MemberList member = new MemberList(emp_id[i], emp_dept[i], emp_name[i], emp_posi[i], emp_tel[i], emp_email[i], emp_level[i]);
			list.add(member);
		}
		memberService.updateAll(list);
		
		return "empManagement.empinfo.memberList";
	}

}
