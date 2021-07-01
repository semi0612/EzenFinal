package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private MemberDAO mapper;
	
	/*생성자 통한 주입*/
	@Autowired
	public MemberDAOImpl(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(MemberDAO.class);
	}

	@Override
	public List list() {
		return mapper.list();
	}

	@Override
	public int add(Member member) {
		return mapper.add(member);
	}

	@Override
	public int editInfo(Member member) {
		return mapper.editInfo(member);
	}

	@Override
	public int del(String emp_id) {
		return mapper.del(emp_id);
	}

	@Override
	public int updatePw(String emp_pw, String emp_id) {
		return mapper.updatePw(emp_pw, emp_id);
	}

	@Override
	public int updateAll(List<MemberList> memberList) {
		return mapper.updateAll(memberList);
	}
	
	@Override
	public List<String> getEmpId() {
		return mapper.getEmpId();
	}

	@Override
	public List<MemberList> listView() {
		return mapper.listView();
	}

	@Override
	public List<MemberLeave> listLeave() {
		return mapper.listLeave();
	}

	@Override
	public List<MemberSal> listSal() {
		return mapper.listSal();
	}

	@Override
	public int count() {
		return mapper.count();
	}

	@Override
	public List<String> listPosi() {
		return mapper.listPosi();
	}

	@Override
	public List<HashMap<String, String>> listTeam() {
		return mapper.listTeam();
	}

}
