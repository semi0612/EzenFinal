package com.clockOn.web.controller.emp;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberProfile;
import com.clockOn.web.service.empManagement.MemberService;
import com.clockOn.web.service.vacation.LeaveService;

import lombok.Setter;



@Controller
@RequestMapping("/emp/") //localhost ~ /emp/login_emp
public class EmpController {
	
	@Setter(onMethod_ = { @Autowired })
	private MemberDAO memberMapper;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private ServletContext ctx;
	
	@GetMapping("main")
	public String emp_main(Principal principal, HttpSession session, Model model) {
		String username = principal.getName();
		model.addAttribute("annday", leaveService.getVacinfo(username));
		System.out.println(username);
		if(session.getAttribute("level")==null) {
			
			Member member= memberMapper.read(username);
	        session.setAttribute("level", member.getEmp_level());
	        session.setAttribute("id", member.getEmp_id());
	        session.setAttribute("name", member.getEmp_name());
		}
		
		
		
		return "emp.main";
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
	
	

	
	@GetMapping("infoUpdate") //보여줄 때
	public String infoUpdate(String emp_id, Model model) {
		model.addAttribute("updateProfile", memberService.profile(emp_id));
		return "emp.infoUpdate";
	}

	
	@PostMapping("infoUpdate") //처리할 때 (form action) 
	public String infoUpdate(String emp_id, String emp_pw, String emp_email, String emp_tel, MultipartFile emp_pic) throws IllegalStateException, IOException {
		//null값이 허용된다면 MemberDAOMapper.xml > 동적쿼리로 만들어야
		String fileName = emp_pic.getOriginalFilename();
		System.out.println(fileName + "hi");
		if(fileName !=null && fileName !="") {
		//파일업로드
			String webPath = "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			File savePath = new File(realPath);
			System.out.println("저장경로2" + savePath);
			if (!savePath.exists())
				savePath.mkdirs();
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			System.out.println("저장경로1" + realPath);
			emp_pic.transferTo(saveFile);
		}
		
		MemberProfile memberProfile = new MemberProfile(emp_id, emp_pw, emp_email, emp_tel, fileName);
		
		System.out.println("수정된 레코드 수:" + memberService.infoUpdate(memberProfile));
		
		return "emp.main"; 

	}

}
