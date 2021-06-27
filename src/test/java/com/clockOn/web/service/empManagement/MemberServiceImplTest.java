package com.clockOn.web.service.empManagement;

import static org.junit.Assert.*;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceImplTest {
//	@Autowired
//	private JavaMailSender mailSender;
	
	@Test
	public void test() {
		int charLen = 8;
		final char[] charTable = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
		Random random = new Random(System.currentTimeMillis());
		int tableLen = charTable.length;
		StringBuffer buf = new StringBuffer();
		
		for(int i=0; i<charLen; i++) {
			/*1~36 까지의 정수형 난수를 반환해서 버퍼의 0~7자리까지 채워넣는다. */
			buf.append(charTable[random.nextInt(tableLen)]);
		}
		System.out.println(buf.toString());
		}
	}

