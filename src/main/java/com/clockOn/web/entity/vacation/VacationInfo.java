package com.clockOn.web.entity.vacation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacationInfo extends Vacation {
	private String org_teamname;
	private String emp_name;
	
	public VacationInfo(String holi_rid, String org_teamname, String emp_id, String emp_name, String holi_period, float holi_cnt, String holi_res, String holi_code, String holi_state, String holi_evi) {
		super(holi_rid, holi_period, holi_cnt, holi_res, holi_state, holi_code, holi_evi, emp_id );
		this.org_teamname = org_teamname;
		this.emp_name = emp_name;
	}
}
