package com.clockOn.web.dao;

import java.util.List;

import com.clockOn.web.entity.Member;


public interface MemberDAO {
	public List list();

	public int add(Member member);

	public int editInfo(Member member);

	public int del(String emp_id);

	public int updatePw(String emp_pw, String emp_id);

	public int updateInfo(Member member);
}
