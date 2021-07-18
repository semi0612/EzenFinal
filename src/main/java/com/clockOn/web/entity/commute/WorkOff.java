package com.clockOn.web.entity.commute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkOff {
	private String work_day;
	private String holi_code;
	private String emp_id;
	
	public WorkOff(String work_day, String holi_code, String emp_id) {
		this.work_day = work_day;
		this.holi_code = holi_code;
		this.emp_id = emp_id;
	}
}
