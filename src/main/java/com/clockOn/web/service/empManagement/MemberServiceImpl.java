package com.clockOn.web.service.empManagement;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.dao.OrgDAO;
import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	PasswordEncoder pwencoder;
	
	@Autowired
	private JavaMailSender mailSender;
	 
	@Autowired
    private MemberDAO memberDao;
	
	@Autowired
	private OrgDAO orgDao;

	@Override
	public int add(Member member) {
		/*빈값으로 넘어 올 경우 사번 생성 */
		if(member.getEmp_id()==null || member.getEmp_id().equals("")) member.setEmp_id(makeEmp_id(member));
		System.out.println(member.getEmp_id());
		/*이메일 전송-1.비밀번호(난수) 생성 및 추가*/
		String emp_pwd = makePw();
		member.setEmp_pw(emp_pwd);
		//2.이메일 보내기
		sendEmail(member.getEmp_id(),member.getEmp_email(), emp_pwd, member.getEmp_name());
		//3.비밀번호 암호화
		member.setEmp_pw(pwencoder.encode(member.getEmp_pw()));
		//4.Dao
		int result = memberDao.add(member);

	    return result;
	}

	private String makeEmp_id(Member member) {
		String id = "";
		String teamCode = "";
		//부서코드[00-99]
		int teamCode_ = orgDao.getTeamCode(member.getEmp_dept());
		if(teamCode_<10) teamCode="0"+teamCode_;
		else teamCode = String.valueOf(teamCode_);
		id +=teamCode;
		
		//직급[0-9]
		String posi="";
		switch(member.getEmp_posi()) {
			case "AB": posi ="0"; break;
			case "인턴": posi ="1"; break;
			case "사원": posi ="2"; break;
			case "주임": posi ="3"; break;
			case "대리": posi ="4"; break;
			case "과장": posi ="5"; break;
			case "차장": posi ="6"; break;
			case "팀장": posi ="7"; break;
			case "부장": posi ="8"; break;
			default: posi ="9"; break;
			
		}
		id +=posi;
		
		//입사연도[00-99]
		String yy="";
		Calendar today = Calendar.getInstance();
		String yy_=String.valueOf(today.get(Calendar.YEAR));
		yy=yy_.substring(2);
		
		id += yy;
		//순서[0-9]
		int no=0;
		id+=no; //01021'0'부터시작
		List<String> list =memberDao.getEmpId();
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i))) {
				no++;
				id = id.substring(0,id.length()-2)+no;
			} else
				break;
		}
		
		return id;
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
		return memberDao.list();
	}

	@Override
	public int update(String emp_id) {
		return 0;
	}
	//관리자페이지 -직원정보 일괄 수정
	@Override
	public int update(MemberList member) {
		return memberDao.updateInfo(member);
	}

	@Override
	public List<MemberList> listView() {
		return memberDao.listView();
	}

	@Override
	public List<MemberLeave> listLeave() {
		return memberDao.listLeave();
	}

	@Override
	public List<MemberSal> listSal() {
		return memberDao.listSal();
	}

	@Override
	public int count() {
		return memberDao.count();
	}

}
