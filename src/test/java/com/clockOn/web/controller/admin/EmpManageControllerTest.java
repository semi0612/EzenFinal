package com.clockOn.web.controller.admin;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@Log4j
public class EmpManageControllerTest {

	@Test
	public void test() {
		Calendar cal = Calendar.getInstance();

		cal.set(2021,8,12);

		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		Integer i = 3;
		System.out.println(4-i);
		
	}

}
