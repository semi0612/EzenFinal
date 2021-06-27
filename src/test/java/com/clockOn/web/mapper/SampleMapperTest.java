package com.clockOn.web.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.cj.util.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleMapperTest {

	@Autowired
	private SampleMapper sampleMapper;
	
	@Test
	public void testGetTime() {
		String className = sampleMapper.getClass().getName();
		System.out.println("className=" + className);
		String now = sampleMapper.getTime();
		System.out.println("now=" + now);
		assertTrue(StringUtils.startsWithIgnoreCase(className, "com.sun.proxy"));
	}
	
	

}
