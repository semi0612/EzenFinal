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
		System.out.println(emp_id);
		model.addAttribute("annday", vacationService.getVacinfo(emp_id));
		
		return "emp.vacation.vcRequest";
	}
	
	
	//요청 페이지 입력 처리
	@PostMapping("request")
	public void sendReq(String period, String kind, String reason, MultipartFile file, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
		/*휴가 기간 처리*/
		String[] p = period.split(" ");
		ArrayList<String> list = new ArrayList<>(Arrays.asList(p));
		// 오름차순으로 정렬 [(n), 1, 2, 3, ...]
		Collections.sort(list);
		String[] m = new String[(p.length-1)];
		String[] d = new String[(p.length-1)];
		/*월, 일 쪼개서 배열에 저장*/
		for(int i=1; i<p.length; i++) {
			m[i] = p[i].split("/")[0];
			d[i] = p[i].split("/")[1];
		}
		/*비교하여 기간별 요청 만들기*/
		
		//임시 요청 배열
		String[] req;
		
		
		//완성되면 List에 추가
//		List<String[]> list = new ArrayList<String[]>();
		
		
		
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
//		new Vacation(holi_start, holi_end, reason, kind, fileName, emp_id);
		response.sendRedirect("vcList");
	}
	
	@GetMapping("vcList")
	public String vacReqlist() {
		
		return "emp.vacation.vcList";
	}
	
	/*
	 * @GetMapping("cancelVacReq") //@RequestParam String id, public void
	 * cancelVacReq(String id, HttpServletResponse response) throws IOException {
	 * int result = vacationService.cancelVacReq(id); System.out.println(result);
	 * response.sendRedirect("vcList");
	 */
}
