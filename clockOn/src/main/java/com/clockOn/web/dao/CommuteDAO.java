package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.clockOn.web.entity.Page;
import com.clockOn.web.entity.commute.Commute;
import com.clockOn.web.entity.commute.CommuteDetail;

public interface CommuteDAO {
	// 출근 찍기
	public int hiSuccess(String emp_id);
	// 출근버튼 처리
	public String work_day(String emp_id);
	// 자신의 출퇴근 데이터 가져오기
	public List<Commute> listRecord(Map<String, String> map);
	// 퇴근 찍기
	public int byeSuccess(String emp_id);
	// 본인 근태 기록 보기
	public List<CommuteDetail> myList(Map<String, String> map);
	// 관리자 - 모든 직원의 근태 기록 가져오기 
	// @Param : 넘겨줄 값이 여러개다보니 제대로 찾아가라고 지정해준다
	// 파람 속 "mapList" 이거는 mapper의 collection과 이름을 맞춰줌
	public List<CommuteDetail> allByList(@Param("mapList") List<Map<String, String>> mapList, @Param("page") Page page);
	
	public int cntRows(List<Map<String, String>> mapList);
	
	/*정연님*/
	// 출근 인원 카운트
	public int goWorkCount();
	// 미출근 인원 카운트
	public int notWorkCount();
	// 휴가 인원 카운트
	public int holidayCount();
	// 지각 인원 카운트
	public int lateCount();
	// 자신의 해당 월 출근 기록 확인
	public int thisMonthWork(String emp_id);
	// 자신의 해당 월 지각 기록 확인
	public int thisMonthLate(String emp_id);
	// 자신의 해당 월 휴무 기록 확인
	public int thisMonthHoli(String emp_id);
	// 자신의 해당 월 근무 시간 확인
	public int thisMonthTime(String emp_id);
	// 자신의 해당 년도 출근 기록 확인
	public int thisYearWork(String emp_id);
	// 자신의 해당 년도 지각 기록 확인
	public int thisYearLate(String emp_id);
	// 자신의 해당 년도 휴무 기록 확인
	public int thisYearHoli(String emp_id);
	// 자신의 해당 년도 근무 시간 확인
	public int thisYearTime(String emp_id);
	// 모든 직원의 근태기록 조회
	public List<HashMap<String, Object>> allMemberCommute();
	//public List<Attendance> allMemberCommute(List<String> list);
	public List<Integer> cntWork();
	// 자신의 해당 월 평일 근무일수 확인
	public int cntWdays(String emp_id);
	// 자신의 해당 년도 근무일수 확인
	public int cntYdays(String emp_id);
	
}
