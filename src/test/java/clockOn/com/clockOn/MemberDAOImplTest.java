package clockOn.com.clockOn;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.member.Member;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberDAOImplTest {

	@Autowired
	private MemberDAO memberDao;
	
	@Test
	public void list() {
		 List<Member> list = memberDao.list();
		 System.out.println(list.get(0).getEmp_join());
	}
	
	@Test
	public void ceil() {
		System.out.println(Math.ceil((double) 238/10));
//		Member member = new Member("")
//		memberDao.add(member);
	}
	@Test
	public void listView() {
		System.out.println(memberDao.listLeave(10, 3).get(0).getEmp_dept());
	}

}
