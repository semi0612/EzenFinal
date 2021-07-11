package com.clockOn.web.entity.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attendance {
	private String emp_id;
	private String emp_dept;
	private String emp_name;
	private int workDay; 
	private int lateDay; 
	private int holiday; 
	private int workingTime; 
}
