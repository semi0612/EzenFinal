package com.clockOn.web.controller.emp;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.clockOn.web.entity.Page;
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
		model.addAttribute("cntwoff", vacationService.cntwoff(emp_id));
		model.addAttribute("cVac",vacationService.comingVac(emp_id));
		List<HashMap<String,String>> list= vacationService.waitingVac(emp_id);
		List<HashMap<String, Object>> wVac = new ArrayList<HashMap<String, Object>>();
		for(HashMap<String, String> map : list) {
			String date = map.get("dates");
			List<String> dates = Arrays.asList(date.split(" / ")); //날짜 문자열
			Collections.sort(dates);
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("dates", dates); //날짜 배열 들어감
			m.put("code", map.get("holi_code"));
			wVac.add(m);
		}
		model.addAttribute("wVac",wVac);
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
		
		String[] off = period.split(" / ");
		String last = off[off.length-1];
		off[off.length-1] = last.substring(0, 8); //날짜별로 쪼개서 배열에 저장
		int indexf = last.indexOf("(");
		int indexl = last.indexOf(")");
		period = period.substring(0, indexf-1);
		float cnt = Float.parseFloat(last.substring(indexf+1,indexl));
		
		int result = vacationService.reqVac(new Vacation(period, cnt, reason, kind, fileName, emp_id));
		response.sendRedirect("vcList");
	}
	
	/*본인 요청 불러오기*/
	@GetMapping("vcList")
	public String vacReqlist(HttpSession session, Model model, @RequestParam(name="p", defaultValue="1") int page) {
		String emp_id = session.getAttribute("id").toString();
		int cnt = vacationService.cntwoff(emp_id);
		model.addAttribute("cntwoff", cnt);
		//페이징 처리 1단계 : 쿼리 실행 시 가져오는 레코드 수 구하기 (count함수 활용)
		int cntReq = vacationService.cntMyReq(emp_id);
		model.addAttribute("cntReq", cntReq);
		//페이징 처리 2단계 : page VO를 통해 필요한 정보 도출 (view : page, startNum, lastNum | mapper : offset, limit)
		Page p = new Page(page,cnt);
		model.addAttribute("pg", p);
		
		List<Vacation> vac = vacationService.listVacReq(emp_id, p.getOffset(), p.getScalePerPage());
		model.addAttribute("vacList",vac);
		
		model.addAttribute("annday", vacationService.getVacinfo(emp_id));
		return "emp.vacation.vcList";
	}
	
	/*쿼리스트링으로 매개값을 받아 일단은 GET요청처리함*/
	@GetMapping("cancelVacReq") //@RequestParam String id,
	public void cancelVacReq(String id, HttpServletResponse response) throws IOException {
		int result = vacationService.cancelVacReq(id);
		System.out.println(result);
		response.sendRedirect("vcList");
	}

}
