package com.clockOn.web.entity;

import java.sql.Date;

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
	private Date emp_join;
	private Date emp_resi;
	private String emp_sal;
	private String emp_pic;
	private int total_annday;
	private int annday_used;

    public Member(String emp_id, String emp_pw, String emp_name, String emp_email, String emp_tel, String emp_dept, String emp_posi, 
            String emp_level, Date emp_join, Date emp_resi, String emp_sal, String emp_pic, int total_annday, int annday_used){
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
			int annday_used, Date emp_join, Date emp_resi) {
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_posi = emp_posi;
		this.total_annday = total_annday;
	    this.annday_used = annday_used;
	    this.emp_join = emp_join;
	    this.emp_resi = emp_resi;
	}

}