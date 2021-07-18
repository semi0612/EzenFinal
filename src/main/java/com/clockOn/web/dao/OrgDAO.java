package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.Criteria;
import com.clockOn.web.entity.Organization;

public interface OrgDAO {
	//모든 팀 리스트 얻기 - 조직도 페이지 & 팀리스트 셀렉트박스
	public List<Organization> list(Criteria cri);
	
	//팀얻기 - 사실 조건에 따른 팀 얻기로 파라미터 들어가야 함. 일단은 만들어둠
	public Organization get();
	
	//팀추가
	public int add(Organization org);
	
	//팀삭제
	public int del(int org_teamcode);
	
	//팀정보 수정
	public int updateInfo(Organization org);
	
	//부서번호 리스트얻기 (직원추가 페이지에서 사용)
	public int getTeamCode(String org_teamname);  

	/*조직도 수(팀수, 본부수)*/
	public HashMap orgCount();
	   
//	public List<Map<String, String>> selectAllMember(); 결과값 Map이 여러개라면 이방식
	
//	public <Map<String, String> selectAllMember(); 결과값 map이 하나라면 이방식
}
