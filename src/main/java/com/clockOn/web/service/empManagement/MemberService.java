package com.clockOn.web.service.empManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberLeave;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberProfile;
import com.clockOn.web.entity.member.MemberSal;

public interface MemberService {
	/* 관리자 - 직원추가 */
	public int add(Member member);

	/* 관리자 - 모든 직원 정보 불러오기 */
	public List<Member> list();

	/* 관리자 - 특정 직원 정보 삭제(미완) */
	public int del(String emp_id);

	/* 관리자 - 특정 직원 정보 수정(미완) */
	public int update(String emp_id);

	/* 관리자 - 여러 직원 정보 일괄 수정 */
	public int updateAll(List<MemberList> list);

	/* 관리자 - 모든 직원 정보 목록형 보기(본부 포함되어야 해서 memberList 따로만듦) */
	public List<MemberList> listView();

	/* 관리자 - 모든 직원 연차정보 가져오기 */
	public List<MemberLeave> listLeave();

	/* 관리자 - 모든 직원 연봉 관련 정보 가져오기 */
	public List<MemberSal> listSal();

	/* 직원&관리자 - 직원 수 구하기 */
	public int count();

	/* 관리자 - 직급 가져오기 ++ 쿼리가 직원 리스트 중 지금 존재하는 직급에서 가져옴(수정필요) */
	public List<String> listPosi();

	/* 본부 별로 팀 목록(문자열) 가져오기 */
	public List<HashMap<String, String>> listTeam();

	/* 로그인, 직원 id로 그 직원의 정보 가져오기 */
	public Member read(String emp_id);

	/* 연락망 직원정보 */
	public List<MemberProfile> contactsRead(String org_teamname);

	/* 직원 개인정보 수정 */
	public int infoUpdate(MemberProfile memberProfile);

	/* 직원&관리자 - 프로필 정보 불러오기 */
	public MemberProfile profile(String emp_id);

	public List<MemberList> searchList(List<Map<String, String>> list);
}
