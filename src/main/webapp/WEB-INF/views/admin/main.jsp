<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
 <body>
	<h1>${(level eq 'ROLE_ADMIN' && status eq 'admin_mode') || (level eq 'ROLE_ADMIN' && empty status)}</h1>
	<h1>${status}</h1>

</body>
</html>