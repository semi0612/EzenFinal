<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/login.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<title>ClockOn Login</title>
</head>
<body>
<c:if test="${not empty error}">
	<script type="text/javascript">
            var error = "${error}";
            var url = "${url}";
            alert(error);
    </script>
</c:if>
	<div class="container">
		<div class="wrapper">
			<div class="title">
				<span>ClockOn Login</span>
			</div>
			<form method="post" action="/login">
				<div class="row">
					<i class="fas fa-user"></i> <input type="text" name="username"	placeholder="사번을 입력해주세요." required>
				</div>
				<div class="row">
					<i class="fas fa-lock"></i> <input type="password" name="password"	placeholder="비밀번호를 입력해주세요." required>
				</div>
				<div class="pass">
					<a href="#">로그인정보를 잊으셨습니까?</a>
				</div>
				<div class="row button">
					<input type="submit" value="로그인">
				</div>
				<div class="signup-link">
					<a href="#">신규직원은 여기를 눌러주세요.</a>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
			</form>
		</div>
	</div>
</body>
</html>