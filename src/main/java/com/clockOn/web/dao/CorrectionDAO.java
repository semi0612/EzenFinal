package com.clockOn.web.dao;

import java.util.List;

import com.clockOn.web.entity.correction.Correction;

public interface CorrectionDAO {

	//직원 - 출퇴근기록 정정요청
	public int corrReq(List<Correction> list);

	public List<Correction> corrList(String emp_id);

}
