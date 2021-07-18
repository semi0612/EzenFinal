package com.clockOn.web.service.empManagement;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.Criteria;
import com.clockOn.web.entity.Organization;

public interface OrgService {
	
	   public List<Organization> orgView(Criteria cri);
	   
	   public HashMap orgCount();
	   

}
