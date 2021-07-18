package com.clockOn.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clockOn.web.entity.commute.Commute;
import com.clockOn.web.service.attendance.CommuteService;

@RestController("CalendarController")
// @ResponseBody를 하지 않아도 알아서 제이슨 데이터타입으로 변환 (제이슨 문자열)
public class CalendarController {
	
	@Autowired
	private CommuteService commuteService;
	
	@PostMapping("/emp/calendar")
	public List<Commute> byCalendar(@RequestParam(value = "dates") String dates, HttpSession session) {
		// 파라미터 2 : dates "2021-07"
		// 파라미터 1 : emp_id -> 세션 사용
		
		String emp_id = session.getAttribute("id").toString();
		Map<String, String> map = new HashMap<>();
		
		map.put("emp_id", emp_id);
		map.put("dates", dates);
		
		
		List<Commute> result = commuteService.listRecord(map);
		// 만약에 js에서 객체를 값으로 가지는 배열을 넘겨주었다면, [{field:'emp_name',
		// keyword:'김'},{field:'emp_name', keyword:'김'}, {field:'emp_name',
		// keyword:'김'}]
		return result;
	}
}
