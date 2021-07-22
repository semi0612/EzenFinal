package com.clockOn.web.entity.commute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommuteDetail extends Commute {
	private String emp_name;
	private String emp_dept;
	private String workingTime;

	public CommuteDetail(String work_rid, String work_day,String emp_name, String emp_dept, String work_in, String work_out, String workingTime, String work_late,
			String holi_code, String work_comm) {
		super(work_rid, work_day, work_in, work_out, work_late, holi_code, work_comm);
		this.emp_name = emp_name;
		this.emp_dept = emp_dept;
		this.workingTime = workingTime;
	}
}


