package com.clockOn.web.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberList {
	private String org_groupname;
	private String emp_dept;
	private String emp_id;
	private String emp_name;
	private String emp_posi;
	private String emp_tel;
	private String emp_email; 
	private String emp_level;


	public MemberList(String org_groupname, String emp_dept, String emp_id, String emp_name, String emp_posi,
			String emp_tel, String emp_email, String emp_level) {
		super();
		this.org_groupname = org_groupname;
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_posi = emp_posi;
		this.emp_tel = emp_tel;
		this.emp_email = emp_email;
		this.emp_level = emp_level;
	}
	
}
