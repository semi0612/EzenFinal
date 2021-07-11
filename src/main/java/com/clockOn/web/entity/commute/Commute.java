package com.clockOn.web.entity.commute;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commute {
	
	private Date work_in;
	private Date work_out;
	private int workDay;
	private int lateDay;
	private int holiday;
	private int workingTime;
	
	
}
