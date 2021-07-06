package com.clockOn.web.controller.emp;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.clockOn.web.entity.vacation.Vacation;
import com.clockOn.web.service.vacation.LeaveService;

@Controller
@RequestMapping("/emp/vacation/")
public class VacReqController {
	@Autowired
	private ServletContext ctx;
	@Autowired
	private LeaveService vacationService;
	
	//요청 페이지
	@GetMapping("request")
	public String vacReq(Model model, Principal principal) {
        String emp_id = principal.getName();
		model.addAttribute("annday", vacationService.getVacinfo(emp_id));
		
		return "emp.vacation.vcRequest";
	}
	
	
	//요청 페이지 입력 처리
	@PostMapping("request")
	public void sendReq(String period, String kind, String reason, MultipartFile file, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
		
		String fileName = file.getOriginalFilename();
		if(fileName !=null && fileName !="") {
		//파일업로드
			String webPath = "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			File savePath = new File(realPath);
			if (!savePath.exists())	savePath.mkdirs();
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			file.transferTo(saveFile);
		}
		String emp_id = session.getAttribute("id").toString();
		int result = vacationService.reqVac(new Vacation(period, reason, kind, fileName, emp_id));
		response.sendRedirect("vcList");
	}
	
	@GetMapping("vcList")
	public String vacReqlist(HttpSession session, Model model) {
		String emp_id = session.getAttribute("id").toString();
		List<Vacation> vac = vacationService.listVacReq(emp_id);
		model.addAttribute("vacList",vac);
		model.addAttribute("annday", vacationService.getVacinfo(emp_id));
		return "emp.vacation.vcList";
	}
	
	/*쿼리스트링으로 매개값을 받아 일단은 GET요청처리함*/
	@GetMapping("cancelVacReq")
	public String cancelVacReq(String id) {
		vacationService.cancelVacReq(id);
		return "emp.vacation.vcList";
	}

}
