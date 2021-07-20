package com.clockOn.web.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Page {
	private int page; //현재페이지번호
	private int scalePerPage = 10; //페이지당 보여줄 자료의 개수 (10개로 고정)
	private int scalePerBlock = 5; //블럭당 보여줄 페이지의 최대 개수 (5개)
	private int offset; //건너뛸 자료의 개수 (1페이지 0, 2페이지 10개)
	private int lastNum; //마지막 페이지 번호
	private double cntRows; //쿼리 결과 자료의 개수
	private int startNum; //현재 블럭에서 시작 페이지 번호 (1, 6, 11, 16, ...)
//	private int lastNum; //현재 블럭에서 마지막 페이지 번호 (5, 10, 15, ...)
	
	
	//Controller에서 Get요청 처리 시 가장 먼저 수행할 작업(생성자)
	public Page(int page, double cntRows) {
		this.page = page;
		this.offset =  0+(page-1)*scalePerPage;
		this.lastNum = (int) Math.ceil(cntRows/scalePerPage); 
		this.cntRows = cntRows;
		this.startNum = page-(page-1)%scalePerBlock; 
	}
	
}
