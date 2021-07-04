package com.clockOn.web.entity.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberProfile {
	
	private String emp_dept;
	private String emp_id;
	private String emp_pw;
	private String emp_name;
	private String emp_posi;
	private String emp_tel;
	private String emp_email; 
	private String emp_pic;
	
	
	public MemberProfile(String emp_dept, String emp_id, String emp_name, String emp_posi, String emp_tel, String emp_email, String emp_pic) {
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_posi = emp_posi;
		this.emp_tel = emp_tel;
		this.emp_email = emp_email;
		this.emp_pic = emp_pic;
	}


	public MemberProfile(String emp_id, String emp_pw, String emp_email, String emp_tel, String fileName) {
		
		this.emp_id = emp_id;
		this.emp_pw = emp_pw;
		this.emp_email = emp_email;
		this.emp_tel = emp_tel;
		this.emp_pic = fileName;
	}
	
	public MemberProfile(String emp_name, String emp_dept, String emp_posi, String emp_email, String emp_tel, String emp_pic) {
	      this.emp_dept = emp_dept;
	      this.emp_name = emp_name;
	      this.emp_posi = emp_posi;
	      this.emp_tel = emp_tel;
	      this.emp_email = emp_email;
	      this.emp_pic = emp_pic;
	   }
	
	
	
}
