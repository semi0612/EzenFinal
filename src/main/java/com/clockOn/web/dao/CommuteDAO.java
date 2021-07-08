package com.clockOn.web.dao;

public interface CommuteDAO {
	// 출근 인원 카운트
	public int goWorkCount();
	// 미출근 인원 카운트
	public int notWorkCount();
	// 휴가 인원 카운트
	public int holidayCount();
	// 지각 인원 카운트
	public int lateCount();
	
}
