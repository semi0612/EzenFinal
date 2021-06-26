package com.clockOn.web.model;

import java.util.List;

public interface MemberDAO {
	public abstract List list();

	public abstract int add(Member member);

	public abstract int editInfo(Member member);

	public abstract int del(String emp_id);

	public abstract int updatePw(String emp_pw, String emp_id);

	public abstract int updateInfo(Member member);
}
