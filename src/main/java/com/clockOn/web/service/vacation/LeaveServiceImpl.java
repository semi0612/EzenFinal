package com.clockOn.web.service.vacation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.VacationDAO;
import com.clockOn.web.entity.commute.WorkOff;
import com.clockOn.web.entity.vacation.Annday;
import com.clockOn.web.entity.vacation.Vacation;
import com.clockOn.web.entity.vacation.VacationInfo;

@Service
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	VacationDAO vacationDao;
	
	@Override
	public Annday getVacinfo(String emp_id) {
		return vacationDao.getVacInfo(emp_id);
	}

	@Override
	public int reqVac(Vacation vacation) {
		return vacationDao.reqVac(vacation);
	}

	@Override
	public List<Vacation> listVacReq(String emp_id, int offset, int limit) {
		
		return vacationDao.listVacReq(emp_id, offset, limit);
		
	}

	@Override
	public List<VacationInfo> listAllVacReq() {
		return vacationDao.listAllVacReq();
	}

	@Override
	public int cancelVacReq(String holi_rid) {
		return vacationDao.cancelVacReq(holi_rid);
	}

	@Override
	public List<VacationInfo> listWaitReq() {
		return vacationDao.listWaitReq();
	}

	@Override
	public int cntReq() {
		return vacationDao.cntReq();
	}

	@Override
	public int cntwReq() {
		return vacationDao.cntwReq();
	}

	@Override
	public int confirm(String holi_rid, String emp_id, String holi_code, String[] offs, String holi_period, float cnt) {
		//근태 테이블 휴가처리 위해 휴가기간 쪼개기
		List<WorkOff> list = new ArrayList();
		for(int i=0; i<offs.length; i++) {
			String work_day= offs[i];
			list.add(new WorkOff(work_day, holi_code, emp_id));
		}
		int result= vacationDao.confirm(holi_rid); //휴가테이블 상태 update
			result += vacationDao.processVac(list); //근태테이블 해당 날짜에 데이터 삽입
			
		if(holi_code.equals("병가")||holi_code.equals("대체휴일")||holi_code.equals("특별휴가")||holi_code.equals("기타"))	cnt = 0.0f;
		Map<String, Object> map = new HashMap();
		map.put("emp_id", emp_id);
		map.put("cnt", cnt);
		result += vacationDao.subAnnday(map);//연차차감
		return result;
	}

	@Override
	public int reject(String holi_rid) {
		return vacationDao.reject(holi_rid);
	}

	@Override
	public int cancel(String holi_rid) {
		return vacationDao.cancel(holi_rid);
	}

	@Override
	public int cntwoff(String emp_id) {
		return vacationDao.cntwoff(emp_id);
	}

	@Override
	public List<HashMap<String, Object>> comingVac(String emp_id) {
		return vacationDao.comingVac(emp_id);
	}

	@Override
	public List<HashMap<String, String>> waitingVac(String emp_id) {
		return vacationDao.waitingVac(emp_id);
	}

	@Override
	public int cntMyReq(String emp_id) {
		return vacationDao.cntMyReq(emp_id);
	}

}
