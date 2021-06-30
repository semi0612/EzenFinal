package com.clockOn.web.service.empManagement;

import java.util.List;

import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;

public interface MemberService {
    public int add(Member member);
    public int edit(String emp_id);
    public int del(String emp_id);
    public List<Member> list();
    public int update(String emp_id);
    public int update(MemberList member);
	public List<MemberList> listView();
	public List<MemberLeave> listLeave();
	public List<MemberSal> listSal();
	public int count();
}
