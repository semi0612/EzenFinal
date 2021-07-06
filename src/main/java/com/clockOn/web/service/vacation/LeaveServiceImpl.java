package com.clockOn.web.service.vacation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.VacationDAO;
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
	public List<Vacation> listVacReq(String emp_id) {
		
		return vacationDao.listVacReq(emp_id);
		
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
	public int confirm(String holi_rid) {
		return vacationDao.confirm(holi_rid);
	}

	@Override
	public int reject(String holi_rid) {
		return vacationDao.reject(holi_rid);
	}

	@Override
	public int cancel(String holi_rid) {
		return vacationDao.cancel(holi_rid);
	}

}
