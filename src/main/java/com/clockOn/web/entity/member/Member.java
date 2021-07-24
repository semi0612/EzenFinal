package com.clockOn.web.entity.member;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member{
	private String emp_id;
	private String emp_pw;
	private String emp_name;
	private String emp_email;
	private String emp_tel;
	private String emp_dept;
	private String emp_posi;
	private String emp_level;
	private String emp_join;
	private String emp_resi;
	private String emp_sal;
	private String emp_pic;
	private int total_annday;
	private float annday_used;
	private List<Auth> auth; 


	
    public Member(String emp_id, String emp_pw, String emp_name, String emp_email, String emp_tel, String emp_dept, String emp_posi, 
            String emp_level, String emp_join, String emp_resi, String emp_sal, String emp_pic, int total_annday, float annday_used){
        this.emp_id = emp_id;
        this.emp_pw = emp_pw;
        this.emp_name = emp_name;
        this.emp_email = emp_email;
        this.emp_tel = emp_tel;
        this.emp_dept = emp_dept;
		this.emp_posi = emp_posi;
        this.emp_level = emp_level;
        this.emp_join = emp_join;
        this.emp_resi = emp_resi;
        this.emp_sal = emp_sal;
        this.emp_pic = emp_pic;
        this.total_annday = total_annday;
        this.annday_used = annday_used;
    }
    

	public Member(String emp_dept, String emp_id, String emp_name, String emp_posi, int total_annday,
			float annday_used, String emp_join, String emp_resi) {
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_posi = emp_posi;
		this.total_annday = total_annday;
	    this.annday_used = annday_used;
	    this.emp_join = emp_join;
	    this.emp_resi = emp_resi;
	}


	public Member(String emp_id, String emp_pw, String emp_name, String emp_level) {
		this.emp_id = emp_id;
		this.emp_pw = emp_pw;
		this.emp_name = emp_name;
		this.emp_level = emp_level;
//		this.auth.add(new Auth(emp_id, emp_level));
	}

}