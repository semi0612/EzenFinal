package com.clockOn.web.service.empManagement;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private JavaMailSender mailSender;
	 
	@Autowired
    private MemberDAO memberDao;

	@Override
	public int add(Member member) {
		System.out.println(" 서비스단 : " + member);
		/*이메일 전송-1.비밀번호(난수) 생성 및 추가*/
		String emp_pwd = makePw();
		member.setEmp_pw(emp_pwd);
		//2.이메일 보내기
		sendEmail(member.getEmp_id(),member.getEmp_email(), emp_pwd, member.getEmp_name());
		//3.Dao
		int result = memberDao.add(member);
		System.out.println(" 반환값 : " + result);

	     return result;
	}

	private void sendEmail(String id, String email, String emp_pwd, String emp_name) {
		String setFrom = "jeeyoolmin@gmail.com";
		String setTo = email;
		String title = "근태관리 시스템 clockOn 합류하기";
		String content =
				emp_name+"님의 아이디는 사번 (" +id +")입니다. <br>" +
				"초기 비밀번호는 " + emp_pwd +"입니다. <br>" +
				"지금 <a href='http://localhost:8090/index'>clockOn</a>에 합류하여 "+
				"로그인 후 비밀번호를 변경해주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(setTo);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String makePw() {
		int charLen = 8;
		final char[] charTable = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
		Random random = new Random(System.currentTimeMillis());
		int tableLen = charTable.length;
		StringBuffer buf = new StringBuffer();
		
		for(int i=0; i<charLen; i++) {
			/*1~36 까지의 정수형 난수를 반환해서 버퍼의 0~7자리까지 채워넣는다. */
			buf.append(charTable[random.nextInt(tableLen)]);
		}
		return buf.toString();
	}

	@Override
	public int edit(String emp_id) {
		return 0;
	}

	@Override
	public int del(String emp_id) {
		return 0;
	}

	@Override
	public List<Member> list() {
		return null;
	}

	@Override
	public int update(String emp_id) {
		return 0;
	}

	@Override
	public int update(Member member) {
		return 0;
	}

}
