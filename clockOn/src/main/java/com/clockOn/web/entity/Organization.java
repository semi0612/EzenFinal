package com.clockOn.web.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {
	private int org_teamcode;
	private String org_groupname;
	private String org_teamname;
	private String org_teamtel;
	private String org_content;
	
	
	public Organization(int org_teamcode, String org_groupname, String org_teamname, String org_teamtel, String org_content) {
		this.org_teamcode = org_teamcode;
		this.org_groupname = org_groupname;
		this.org_teamname = org_teamname;
		this.org_teamtel = org_teamtel;
		this.org_content = org_content;
	}
	
}
	
