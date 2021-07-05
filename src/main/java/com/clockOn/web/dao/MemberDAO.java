package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberLeave;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberProfile;
import com.clockOn.web.entity.member.MemberSal;


public interface MemberDAO {
	/*지율*/
	public List list();

	public int add(Member member);
	
	public int count();

	public int editInfo(Member member);

	public int del(String emp_id);

	public int updateAll(List<MemberList> member);
	
	public List<String> getEmpId();

	public List<MemberList> listView();
	
	public List<MemberLeave> listLeave();

	public List<MemberSal> listSal();

	public List<String> listPosi();

	public List<HashMap<String, String>> listTeam();
	
	/*정연님 level 처리 확인하기(테이블 합쳤음)*/
	public Member read(String emp_id);
	
	public List<MemberProfile> contactsRead(String org_teamname);
	
	public MemberProfile profile(String emp_id);
	
	/*예슬님*/   
	public int infoUpdate(MemberProfile member);
	   
}
