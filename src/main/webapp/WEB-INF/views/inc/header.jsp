<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div id="menu">
		<ul class="navbar-nav">
			<li class="nav-item open" onclick="fix_menu()">
			<i class="fas fa-solid fa-bars" alt="메뉴고정"></i> <span class="tooltip">
					메뉴 고정/해제</span></li>
			<li class="nav-item company-name">
				<!---->
				<span> HMG </span>
			</li>
			<li class="nav-item setting" onclick="dp_menu()"><a><i
					class="fas fa-cog"></i></a>
				<ul class="dropdown-menu dropdown-menu-right show" id="drop-content">
					<li class="full-name">${name}</li>
					<!-- <li class="link"><a class="dropdown-item"><i class="fas fa-user-alt"></i> 계정 설정 </a></li>
					<li class="dropdown-divider"></li> -->
					<!-- 권한이 관리자 이면서 status = admin_mode(관리자모드) 이거나 또는 권한이 관리자 이면서 status가 없을때 -->
					<c:if test="${(level eq 'ROLE_ADMIN' && status eq 'admin_mode') || (level eq 'ROLE_ADMIN' && empty status)}">
						<li class="link"><a onclick="document.getElementById('to_emp').submit();" class="dropdown-item"><i class="fas fa-sign-out-alt"></i> 직원 모드로 전환 </a></li>
						<li class="dropdown-divider"></li>
					</c:if>
					<!-- 권한이 관리자 이면서 status = emp_mode(직원모드) 일때 -->	
					<c:if test="${level eq 'ROLE_ADMIN' && status eq 'emp_mode'}">
						<li class="link"><a href="/emp/infoUpdate?emp_id=${id}" class="dropdown-item" style="text-decoration: none;"><i class="fas fa-user-alt"></i> 계정 설정 </a></li>
						<li class="dropdown-divider"></li>
						<li class="link"><a onclick="document.getElementById('to_admin').submit();" class="dropdown-item"><i class="fas fa-sign-out-alt"></i> 관리자 모드로 전환 </a></li>
					</c:if>
					<!-- 권한이 멤버일때  -->
					<c:if test="${level eq 'ROLE_MEMBER'}">
						<li class="link"><a href="/emp/infoUpdate?emp_id=<sec:authentication property='principal.member.emp_id' />" class="dropdown-item" style="text-decoration: none; color: black;"><i class="fas fa-user-alt"></i> 계정 설정 </a></li>
						<li class="dropdown-divider"></li>
					</c:if>	
					<li class="link"><a onclick="document.getElementById('logout').submit();" class="dropdown-item"><i
							class="fas fa-sign-out-alt"></i> 로그아웃 </a></li>
				</ul>
			</li>
		</ul>
	</div>
	
	<form id="to_emp" action="/emp/mode" method="POST"></form>
	<form id="to_admin" action="/admin/mode" method="POST"></form>
	
	<form id="logout" action="/logout" method="POST">
   		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
	</form>
</header>