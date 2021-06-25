package com.clockOn.web.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	/*
	 * @Inject SqlSession sqlSession;
	 */
	@Override
	public List<MemberDTO> list() {
		return null;
		/*
		 * return sqlSession.selectList("member.list"); //member 네임스페이스 list 태그의 아이디
		 */	}
}
