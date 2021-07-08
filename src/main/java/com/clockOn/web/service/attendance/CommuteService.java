package com.clockOn.web.service.attendance;

public interface CommuteService {

	// 출근 인원 카운트
		public int goWorkCount();
		// 미출근 인원 카운트
		public int notWorkCount();
		// 휴가 인원 카운트
		public int holidayCount();
		// 지각 인원 카운트
		public int lateCount();

}
