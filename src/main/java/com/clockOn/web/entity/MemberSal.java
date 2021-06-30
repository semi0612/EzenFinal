package com.clockOn.web.entity;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//여기서는 상속을 하지않고 필요한 컬럼만 꺼내 만듦. 생성자 신경써서 만들 필요 X
public class MemberSal {
	private String org_groupname;
	private String emp_dept;
	private String emp_id;
	private String emp_name;
	private String emp_posi;
	private String emp_sal;
	private String emp_pay;
	private Date emp_join;
	private Date emp_resi;
	
	public MemberSal(String org_groupname, String emp_dept, String emp_id, String emp_name, String emp_posi, String emp_sal,
			String emp_pay,Date emp_join, Date emp_resi) {
		this.org_groupname = org_groupname;
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_posi = emp_posi;
		this.emp_sal = emp_sal;
		this.emp_pay = emp_pay;
		this.emp_join = emp_join;
		this.emp_resi = emp_resi;
	}

}
