package com.clockOn.web.service.correction;

import java.util.List;

import com.clockOn.web.entity.correction.Correction;

public interface CorrectionService {

	//직원 - 출퇴근기록 정정요청
	public int corrReq(List<Correction> list);
	
	//직원 - 정정 리스트
	public List<Correction> corrList(String emp_id);
	
	//관리자 - 전 직원 출퇴근 기록 정정 리스트 출력(진행중인 요청)
	public List<Correction> corrListAll();

}
