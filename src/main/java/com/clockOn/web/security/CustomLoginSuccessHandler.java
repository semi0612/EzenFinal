package com.clockOn.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;
// 로그인 성공 시 이동 할 페이지를 처리해주는 핸들러
@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	
	@Autowired
	private HttpSession session;
	
	
	
	@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication auth) throws IOException, ServletException {
			
		
			log.warn("Login Success");
			
			List<String> roleNames = new ArrayList<>();
			
			auth.getAuthorities().forEach(authority -> {
				roleNames.add(authority.getAuthority());
			});
			
			
			log.warn("ROLE NAMES: " + roleNames);
			// 만약 로그인 된 권한이 "ROLE_ADMIN" 이면  "/admin/empManagement/organization" 경로로 자동 이동한다.
			if(roleNames.contains("ROLE_ADMIN")) {
				
				response.sendRedirect("/admin/main");
				return;
			}
			// 만약 로그인 된 권한이 "ROLE_MEMBER" 이면  "/sample/member" 경로로 자동 이동한다.
			if(roleNames.contains("ROLE_MEMBER")) {
				
				
				response.sendRedirect("/emp/main");
				return;
			}
			
			response.sendRedirect("/");
			
		}

}
