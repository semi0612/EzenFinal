<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- <sec:authentication property="principal.member.emp_id" var="id"/> --%>
	<h1>${(level eq 'ROLE_ADMIN' && status eq 'admin_mode') || (level eq 'ROLE_ADMIN' && empty status)}</h1>
	<h1>${status}</h1>
</body>
</html>