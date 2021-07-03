package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberLeave;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberSal;

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
	public int count() {
		return mapper.count();
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
	public int updateAll(List<MemberList> member) {
		return mapper.updateAll(member);
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
	public List<String> listPosi() {
		return mapper.listPosi();
	}

	@Override
	public List<HashMap<String, String>> listTeam() {
		return mapper.listTeam();
	}

	@Override
	public Member read(String emp_id) {
		return mapper.read(emp_id);
	}

	@Override
	public List<Member> contactsRead(String org_teamname) {
		return mapper.contactsRead(org_teamname);
	}

	@Override
	public int infoUpdate(Member member) {
		return mapper.infoUpdate(member);
	}

}
