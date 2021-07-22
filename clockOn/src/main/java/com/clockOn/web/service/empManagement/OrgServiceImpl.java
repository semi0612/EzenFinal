package com.clockOn.web.service.empManagement;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.OrgDAO;
import com.clockOn.web.entity.Organization;
@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgDAO orgDao;

	@Override
	public List<Organization> orgView() {
		return orgDao.list();
	}

	@Override
	public HashMap orgCount() {
		return orgDao.orgCount();
	}

}
