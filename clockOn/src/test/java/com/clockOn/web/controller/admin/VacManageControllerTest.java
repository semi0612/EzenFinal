package com.clockOn.web.controller.admin;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

public class VacManageControllerTest {

	@Test
	public void confirmReq() throws IOException {
		String holi_period = "21-01-03 / 23-20-19 / 29-39-92 (3)";
		String[] off = holi_period.split(" / ");
		String last = off[off.length-1];
		off[off.length-1] = last.substring(0, 8); //날짜별로 쪼개서 배열에 저장
		int indexf = last.indexOf("(");
		int indexl = last.indexOf(")");
		System.out.println(last + " " + indexf +" "+ indexl);
		System.out.println("시작할 인덱스"+(indexf+1) + "마지막 인덱스" + (indexl-1));
		last = last.substring((indexf+1),(indexl));
		System.out.println("last : " + last);
		float cnt = Float.parseFloat(last);
		System.out.println(cnt);
		for(String o : off) {
			System.out.println(o);
		}
		
	}
}
