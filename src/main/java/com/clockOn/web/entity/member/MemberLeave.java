package com.clockOn.web.entity.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberLeave extends Member {
	private float annday_rest;

	public MemberLeave(String emp_id, String emp_pw, String emp_name, String emp_email, String emp_tel, String emp_dept,
			String emp_posi, String emp_level, String emp_join, String emp_resi, String emp_sal, String emp_pic,
			int total_annday, float annday_used) {
		super(emp_id, emp_pw, emp_name, emp_email, emp_tel, emp_dept, emp_posi, emp_level, emp_join, emp_resi, emp_sal, emp_pic,
				total_annday, annday_used);
	}

	public MemberLeave(String emp_id, String emp_pw, String emp_name, String emp_email, String emp_tel, String emp_dept,
			String emp_posi, String emp_level, String emp_join, String emp_resi, String emp_sal, String emp_pic,
			int total_annday, float annday_used, float annday_rest) {
		super(emp_id, emp_pw, emp_name, emp_email, emp_tel, emp_dept, emp_posi, emp_level, emp_join, emp_resi, emp_sal,
				emp_pic, total_annday, annday_used);
		this.annday_rest = annday_rest;
	}
	
	public MemberLeave(String emp_dept, String emp_id, String emp_name, String emp_posi, int total_annday, 
			float annday_used, int annday_rest, String emp_join, String emp_resi) {
		super(emp_dept, emp_id, emp_name, emp_posi, total_annday, annday_used, emp_join, emp_resi);
		this.annday_rest = annday_rest;
	}
	
	
}
