package com.clockOn.web.dao;

import java.util.List;
import java.util.Map;

import com.clockOn.web.entity.commute.Commute;

public interface CommuteDAO {
	// 출근 인원 카운트
	public int goWorkCount();
	// 미출근 인원 카운트
	public int notWorkCount();
	// 휴가 인원 카운트
	public int holidayCount();
	// 지각 인원 카운트
	public int lateCount();
	// 출근 찍기
	public int hiSuccess(String emp_id);
	// 자신의 해당 월 출근 기록 확인
	public int thisMonthWork(String emp_id);
	// 자신의 해당 월 지각 기록 확인
	public int thisMonthLate(String emp_id);
	// 자신의 출퇴근 데이터 가져오기
	public List<Commute> listRecord(Map<String, String> map);
	
}
