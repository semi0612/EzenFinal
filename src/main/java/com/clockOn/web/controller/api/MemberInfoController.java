package com.clockOn.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clockOn.web.entity.Page;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberSal;
import com.clockOn.web.service.empManagement.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("MemberInfoController") // @ResponseBody를 하지 않아도 알아서 제이슨 데이터타입으로 변환(제이슨 문자열)
@RequestMapping("/admin/empManagement/")
public class MemberInfoController {
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private MemberService service;
	
	//ResponseBody -- 바로 제이슨 문자열로 받고 보내줌
	@PostMapping("searchlist")
	public Map<String,Object> searchResult(@RequestParam(value = "search") String search, @RequestParam(value="page", defaultValue = "1") int p, @RequestParam(value="order") String o) throws JsonMappingException, JsonProcessingException {
		List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		Map<String, String> order = mapper.readValue(o, new TypeReference<Map<String, String>>(){});
		double totRows = service.cntRows(mapList);
		/*select count(1) ~~~~~~~~~~*/
		Page page = new Page(p, totRows, 13);
		List<MemberList> member =service.searchList(mapList, page, order);
		Map<String,Object> data = new HashMap();
		data.put("member", member);
		data.put("totRows",totRows);
		data.put("lastNum", page.getLastNum());
        return data;
	}
	
	@PostMapping("salarylist")
	public Map<String,Object> salaryList(@RequestParam(value = "search") String search, @RequestParam(value="page", defaultValue = "1") int p) throws JsonMappingException, JsonProcessingException {
		List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		double totRows = service.cntSalRows(mapList);
		Page page = new Page(p, totRows, 13);
		List<MemberSal> member =service.salList(mapList, page);
		Map<String,Object> data = new HashMap();
		data.put("member", member);
		data.put("totRows",totRows);
		data.put("lastNum", page.getLastNum());
		return data;
	}
	
	@PostMapping("leavelist")
	public Map<String,Object> leaveList(@RequestParam(value = "search") String search, @RequestParam(value="page", defaultValue = "1") int p) throws JsonMappingException, JsonProcessingException {
		List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		double totRows = service.cntLeaveRows(mapList);
		Page page = new Page(p, totRows, 13);
		List<MemberSal> member =service.leaveList(mapList, page);
		Map<String,Object> data = new HashMap();
		data.put("member", member);
		data.put("totRows",totRows);
		data.put("lastNum", page.getLastNum());
		return data;
	}
	
	
	
	/*
	 * @PostMapping("searchlist") public List<MemberList>
	 * searchResult(@RequestParam(value = "search") String search) throws
	 * JsonMappingException, JsonProcessingException {
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); // List<Search> list =
	 * mapper.readValue(search, new TypeReference<List<Search>>() {}); //
	 * List<MemberList> model =service.searchList(list); List<Map<String, String>>
	 * mapList = mapper.readValue(search, new TypeReference<List<Map<String,
	 * String>>>(){}); System.out.println(search); //
	 * System.out.println(mapList.get(0).get("field")); //
	 * System.out.println(mapList.get(0).get("key")); //
	 * System.out.println(mapList.get(1).get("key")); //
	 * System.out.println(mapList.get(1).get("field")); List<MemberList> model
	 * =service.searchList(mapList); return model; }
	 */
}
