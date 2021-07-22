package com.clockOn.web.entity.correction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Correction {

	private String work_cor_rid;
	private String cor_work_day;
	private String cor_work_in;
	private String cor_work_out;
	private String cor_work_res;
	private String cor_work_req;
	private String cor_work_state;
	private String work_rid;
	private String emp_id;
	
	
	public Correction(String work_cor_rid, String cor_work_day, String cor_work_in, String cor_work_out,
			String cor_work_res, String cor_work_req, String cor_work_state, String work_rid, String emp_id) {
		this.work_cor_rid = work_cor_rid;
		this.cor_work_day = cor_work_day;
		this.cor_work_in = cor_work_in;
		this.cor_work_out = cor_work_out;
		this.cor_work_res = cor_work_res;
		this.cor_work_req = cor_work_req;
		this.cor_work_state = cor_work_state;
		this.work_rid = work_rid;
		this.emp_id = emp_id;
	}

	/*자신의 정정 요청 내역 확인하기 (페이정 처리 이전)*/
	public Correction(String work_cor_rid, String cor_work_day, String cor_work_in, String cor_work_out,
			String cor_work_res, String cor_work_req, String cor_work_state) {
		this.work_cor_rid = work_cor_rid;
		this.cor_work_day = cor_work_day;
		this.cor_work_in = cor_work_in;
		this.cor_work_out = cor_work_out;
		this.cor_work_res = cor_work_res;
		this.cor_work_req = cor_work_req;
		this.cor_work_state = cor_work_state;
	}
	
	
	
}
