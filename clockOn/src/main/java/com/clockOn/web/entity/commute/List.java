package com.clockOn.web.entity.commute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class List extends Commute{
	private String org_groupname;
	private String workingTime;
	
	public List(String work_rid, String work_day, String work_in, String work_out, String work_late, String holi_code,
			String work_comm, String emp_id, String workingTime, String org_groupname) {
		super(work_rid, work_day, work_in, work_out, work_late, holi_code, work_comm, emp_id);
		this.workingTime = workingTime;
		this.org_groupname = org_groupname;
	}
	
}
