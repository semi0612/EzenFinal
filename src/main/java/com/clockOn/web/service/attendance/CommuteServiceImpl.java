package com.clockOn.web.service.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.CommuteDAO;

@Service
public class CommuteServiceImpl implements CommuteService{

	@Autowired
	private CommuteDAO commuteDAO;

	@Override
	public int goWorkCount() {
		return commuteDAO.goWorkCount();
	}

	@Override
	public int notWorkCount() {
		return commuteDAO.notWorkCount();
	}

	@Override
	public int holidayCount() {
		return commuteDAO.holidayCount();
	}

	@Override
	public int lateCount() {
		return commuteDAO.lateCount();
	}

	@Override
	public int hiSuccess(String emp_id) {

		return commuteDAO.hiSuccess(emp_id);
	}

	@Override
	public int thisMonthWork(String emp_id) {

		return commuteDAO.thisMonthWork(emp_id);
	}

	@Override
	public int thisMonthLate(String emp_id) {
		return commuteDAO.thisMonthLate(emp_id);
	}

}
