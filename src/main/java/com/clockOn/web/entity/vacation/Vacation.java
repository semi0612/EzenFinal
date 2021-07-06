package com.clockOn.web.entity.vacation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vacation {
	private String holi_rid;
	private String holi_period;
	private String holi_res;
	private String holi_state;	//int? 보류:0 승인:1 거절:2
	private String holi_code;	//휴가 종류
	private String holi_evi;
	private String emp_id;
	
	/*휴가신청 정보 insert*/
	public Vacation(String holi_period, String holi_res, String holi_code, String holi_evi, String emp_id) {
		this.holi_period = holi_period;
		this.holi_res = holi_res;
		this.holi_code = holi_code;
		this.holi_evi = holi_evi;
		this.emp_id = emp_id;
	}

	public Vacation(String holi_rid, String holi_period, String holi_res, String holi_state, String holi_code, String holi_evi, String emp_id) {
		this.holi_rid = holi_rid;
		this.holi_period = holi_period;
		this.holi_res = holi_res;
		this.holi_state = holi_state;
		this.holi_code = holi_code;
		this.holi_evi = holi_evi;
		this.emp_id = emp_id;
	}
	/*모든,특정 직원 휴가요청정보 불러오기*/
	public Vacation(String holi_rid, String holi_period, String holi_res, String holi_code, String holi_state, String holi_evi) {
		this.holi_rid = holi_rid;
		this.holi_period = holi_period;
		this.holi_res = holi_res;
		this.holi_state = holi_state;
		this.holi_code = holi_code;
		this.holi_evi = holi_evi;
	}
}
