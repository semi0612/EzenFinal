package com.clockOn.web.service.correction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.CorrectionDAO;
import com.clockOn.web.entity.correction.Correction;

@Service
public class CorrectionServiceImpl implements CorrectionService {

	@Autowired
	private CorrectionDAO correctionDAO;

	@Override //근태 기록 생성
	public int corrReq(List<Correction> list) {
		
		//요청하는 날짜가 단일날짜일 때
		for(int i=0; i<list.size(); i++) {
				list.get(i).setCor_work_req("출퇴근 정정");
		}
		return correctionDAO.corrReq(list); 
	}
		
					
		
		 /* //1) 출퇴근 모두 누락인 경우 
		Stirng in_ = correction.getCor_work_in().substring(0,2);
					int in = Integer.parseInt(in);
		if(correction.getCor_work_in() == null && correction.getCor_work_out() == null) {
		  
		  //cor_work_req 추가 //해당 건은 출퇴근 둘다 null값이므로 출퇴근 정정으로 값 지정해서 넣음
		  correction.setCor_work_req("출퇴근 정정");
		  
		  
		  }
		  
		  //퇴근 누락인 경우
		else if(correction.getCor_work_out() == null) {
		  
		  correction.setCor_work_state("대기");
		  
		  if(correction.getCor_work_in() == null) {
		  
		  correction.setCor_work_in("출근 정정");
		  
		  } else {
		  
		  correction.setCor_work_in("퇴근 정정");
		  
		  } 
		  //지각인 경우  (추가해야함 )
			
		  
		  //출근시간과 퇴근시간이 null이 아니지만 정정을 희망하는 경우 
		  else if(correction.getCor_work_in() != null && correction.getCor_work_out() != null) {
		  
		  //cor_work_in과 cor_work_out을 정정신청한 값 넣기
		  correction.setCor_work_in(correction.getCor_work_in());
		  correction.setCor_work_out(correction.getCor_work_out());
		  
		  correction.setCor_work_req("출퇴근시간 정정");
		  
		  correction.setCor_work_state("정정요청"); }
		  
		  int result = correctionDAO.corrReq(correction);
		 */
		

	@Override
	public List<Correction> corrList(String emp_id) {
		// 출퇴근 테이블에서 승인대기, 정정요청 버튼이 어떨때 떠야하는지에 대해 조건문 추가
		// (요청에 대한 로직만 처리)
		return correctionDAO.corrList(emp_id);
	}
	
	@Override
	public List<Correction> corrListAll() {
		
		//내역 조회에서 진행중인 요청만 보여야 하므로 승인대기만 보이도록 조건 처리
		/*
		 * if(correction.getCor_work_state() != "승인대기") { return null; }
		 */
		
		return correctionDAO.corrListAll();
	}

}
