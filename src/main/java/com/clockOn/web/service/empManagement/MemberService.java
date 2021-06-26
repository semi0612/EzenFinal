package com.clockOn.web.service.empManagement;

import java.util.List;

import com.clockOn.web.model.Member;

public interface MemberService {
    public abstract int add(Member member);
    public abstract int edit(String emp_id);
    public abstract int del(String emp_id);
    public abstract List<Member> list();
    public abstract int update(String emp_id);
    public abstract int update(Member member);
}
