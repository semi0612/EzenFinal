package com.clockOn.web.service.empManagement;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.dao.OrgDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberServiceImplTest {
//	@Autowired
//	private JavaMailSender mailSender;

	@Autowired
	private OrgDAO orgDao;
	
	@Autowired
    private MemberDAO memberDao;

	@Test
	public void getAuth() {
		System.out.println(memberDao.read("068210").getAuth().get(0).getEmp_level()+memberDao.read("068210").getAuth().get(0).getEmp_id());
		
	}
	
	@Test
	public void makePW() {
		int charLen = 8;
		final char[] charTable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		Random random = new Random(System.currentTimeMillis());
		int tableLen = charTable.length;
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < charLen; i++) {
			/* 1~36 까지의 정수형 난수를 반환해서 버퍼의 0~7자리까지 채워넣는다. */
			buf.append(charTable[random.nextInt(tableLen)]);
		}
		System.out.println(buf.toString());
	}

	@Test
	public void makeId() {
		String id = "";
		String teamCode = "";
		//부서코드[00-99]
		int teamCode_=0;/* = orgDao.getTeamCode("개발1팀"); */
		if(teamCode_<10) teamCode="0"+teamCode_;
		else teamCode = String.valueOf(teamCode_);
		id +=teamCode;
		System.out.println("부서코드:" + id);
		//직급[0-9]
		String posi="";
		switch("사원") {
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
		System.out.println("부서코드+직급:" + id);
		
		//입사연도[00-99]
		String yy="";
		Calendar today = Calendar.getInstance();
		String yy_=String.valueOf(today.get(Calendar.YEAR));
		yy=yy_.substring(2);
		
		id += yy;
		//순서[0-9]
		int no=0;
		id+=no; //01021'0'부터시작
		System.out.println("부서코드+직급+순서:" + id);
		List<String> list = memberDao.getEmpId();
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i))) {
				no++;
				id = id.substring(0,id.length()-2)+no;
			} else
				break;
		}
		System.out.println("완성: " + id);
	}
}
