package com.clockOn.web.service.empManagement;

import java.util.List;

import com.clockOn.web.entity.Member;

public interface MemberService {
    public int add(Member member);
    public int edit(String emp_id);
    public int del(String emp_id);
    public List<Member> list();
    public int update(String emp_id);
    public int update(Member member);
}
