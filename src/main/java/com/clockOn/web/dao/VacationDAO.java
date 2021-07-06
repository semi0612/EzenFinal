package com.clockOn.web.dao;

import java.util.List;

import com.clockOn.web.entity.vacation.Annday;
import com.clockOn.web.entity.vacation.Vacation;
import com.clockOn.web.entity.vacation.VacationInfo;

public interface VacationDAO {

	public Annday getVacInfo(String emp_id);

	public int reqVac(Vacation vacation);

	public List<Vacation> listVacReq(String emp_id);

	public int cancelVacReq(String holi_rid);

	/*°ü¸®ÀÚ*/
	public List<VacationInfo> listAllVacReq();
	
	public List<VacationInfo> listWaitReq();

	public int cntReq();
	
	public int cntwReq();

	public int confirm(String holi_rid);

	public int reject(String holi_rid);
	
	public int cancel(String holi_rid);

}
