package com.clockOn.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;
// 로그인 시 해당 페이지에 대한 권한이 없을 때 이동 할 페이지를 정해주는 핸들러 
@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler{
	
	@Override
		public void handle(HttpServletRequest request, HttpServletResponse response,
				AccessDeniedException accessDeniedException) throws IOException, ServletException {
			
			log.error("Access Denied Handler");
			log.error("Redirect.......");
			response.sendRedirect("/accessError");
			
		}
}
