package com.clockOn.web.service.attendance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.CommuteDAO;
import com.clockOn.web.entity.commute.Commute;

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

	@Override
	public List<Commute> listRecord(Map<String, String> map ) {
		return commuteDAO.listRecord(map);
	}

}
