package com.clockOn.web.service.vacation;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.vacation.Annday;
import com.clockOn.web.entity.vacation.Vacation;
import com.clockOn.web.entity.vacation.VacationInfo;

public interface LeaveService {
	/*직원 총연차, 남은연차 얻기*/
	Annday getVacinfo(String emp_id);

	int reqVac(Vacation vacation);

	List<Vacation> listVacReq(String emp_id);

	List<VacationInfo> listAllVacReq();

	int cancelVacReq(String id);

	List<VacationInfo> listWaitReq();

	int cntReq();
	
	int cntwReq();

	int reject(String holi_rid);

	int cancel(String holi_rid);

	int confirm(String holi_rid, String emp_id, String holi_code, String[] offs, String holi_period, float cnt);

	int cntwoff(String emp_id);

	List<HashMap<String, Object>> comingVac(String emp_id);

	List<HashMap<String, String>> waitingVac(String emp_id);
		
}
