package com.clockOn.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Setter;

public class Test {
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	

	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	@org.junit.Test
	public void test() {
		String[] arr = {"7/8", "7/5", "7/1","8/20", "8/1","7/3", "(7)", "8/31"};
		// ArrayList 준비
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
		System.out.println("원본 : " + list); // [C, A, B, a]
		// 오름차순으로 정렬
		Collections.sort(list);
		System.out.println("오름차순 : " + list); // [A, B, C, a]
		String[] m = new String[(arr.length)];
		String[] d = new String[(arr.length)];
		for(int i=1; i<list.size(); i++) {
			m[i] = list.get(i).split("/")[0];
			d[i] = list.get(i).split("/")[1];
			System.out.print(m[i]+"/");
			System.out.println(d[i]);
		}
		
	}
	
	@org.junit.Test
	public void testupdate() {


		String sql = "update employee set emp_pw = ? where emp_id = '072210'";



		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, pwencoder.encode("1234"));
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
			if(con != null) { try { con.close();  } catch(Exception e) {} }

		}

	}
}
