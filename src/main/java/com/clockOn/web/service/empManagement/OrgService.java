package com.clockOn.web.service.empManagement;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.Organization;
import com.clockOn.web.entity.PagingVO;

public interface OrgService {

	public List<Organization> orgView(PagingVO vo);

	//게시판 리스트의 갯수 출력
	public int countList();

	public HashMap orgCount();


}
