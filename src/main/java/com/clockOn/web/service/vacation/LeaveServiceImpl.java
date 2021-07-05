package com.clockOn.web.service.vacation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.VacationDAO;
import com.clockOn.web.entity.vacation.Annday;

@Service
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	VacationDAO vacationDao;
	
	@Override
	public Annday getVacinfo(String emp_id) {
		return vacationDao.getVacInfo(emp_id);
	}

}
