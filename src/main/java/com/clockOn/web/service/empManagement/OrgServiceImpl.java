package com.clockOn.web.service.empManagement;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.OrgDAO;
import com.clockOn.web.entity.Organization;
import com.clockOn.web.entity.PagingVO;
@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgDAO orgDao;
	
	@Override
	public List<Organization> orgList() {
		return orgDao.orgList();
	}
	@Override
	public List<Organization> orgView(PagingVO vo) {
		return orgDao.list(vo);
	}
	@Override
	public int countList() {
	    return orgDao.countList();
	}

	@Override
	public HashMap orgCount() {
		return orgDao.orgCount();
	}
	

}
