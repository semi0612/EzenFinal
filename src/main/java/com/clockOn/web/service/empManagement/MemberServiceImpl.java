package com.clockOn.web.service.empManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
    private MemberDAO memberDao;

	@Override
	public int add(Member member) {
		 int result = memberDao.add(member);
	     return result;
	}

	@Override
	public int edit(String emp_id) {
		return 0;
	}

	@Override
	public int del(String emp_id) {
		return 0;
	}

	@Override
	public List<Member> list() {
		return null;
	}

	@Override
	public int update(String emp_id) {
		return 0;
	}

	@Override
	public int update(Member member) {
		return 0;
	}

}
