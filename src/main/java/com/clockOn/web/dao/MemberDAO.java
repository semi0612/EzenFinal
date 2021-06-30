package com.clockOn.web.dao;

import java.util.List;

import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;


public interface MemberDAO {
	public List list();

	public int add(Member member);
	
	public int count();

	public int editInfo(Member member);

	public int del(String emp_id);

	public int updatePw(String emp_pw, String emp_id);

	public int updateInfo(MemberList member);
	
	public List<String> getEmpId();

	public List<MemberList> listView();
	
	public List<MemberLeave> listLeave();

	public List<MemberSal> listSal();
}
