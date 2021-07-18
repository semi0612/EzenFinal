package com.clockOn.web.service.attendance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clockOn.web.entity.commute.Commute;

public interface CommuteService {
	/* 샘이님 */
	// 출근버튼 처리
	public String work_day(String emp_id);
	// 출근 찍기
	public int hiSuccess(String emp_id);
	// 자신의 출퇴근 데이터 가져오기
	public List<Commute> listRecord(Map<String, String> map);

	
	/* 정연님 */
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
	// 자신의 해당 월 결근 기록 확인
	public int thisMonthAbsent(String emp_id);
	// 자신의 해당 년도 출근 기록 확인
	public int thisYearWork(String emp_id);
	// 자신의 해당 년도 지각 기록 확인
	public int thisYearLate(String emp_id);
	// 자신의 해당 년도 휴무 기록 확인
	public int thisYearHoli(String emp_id);
	// 자신의 해당 년도 근무 시간 확인
	public int thisYearTime(String emp_id);
	// 자신의 해당 년도 결근 기록 확인
	public int thisYearAbsent(String emp_id);
	// 모든 직원의 근태기록 조회
	public List<HashMap<String, Object>> allMemberCommute();

}
