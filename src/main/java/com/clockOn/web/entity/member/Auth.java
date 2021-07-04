package com.clockOn.web.entity.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Auth {
	private String emp_id;
	private String emp_level;

	public Auth(String emp_id, String emp_level) {
		this.emp_id = emp_id;
		this.emp_level = emp_level;
	}
}
