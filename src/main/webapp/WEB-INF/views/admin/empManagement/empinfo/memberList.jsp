<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<main>
		<h2>직원정보관리</h2>
		<div class="sub-tab">
			<span class="tab-group1">
				<h4>서브메뉴</h4> <span class="wrap"><button class="button-three">연차</button></span>
				<span class="wrap"><button class="button-three">급여</button></span>
			</span> <span class="tab-group2">
				<h4>직원정보</h4> <span class="wrap"><button class="button-two">직원추가</button></span>
				<span class="wrap"><button class="button-two">수정</button></span> <span
				class="wrap"><button class="button-two">삭제</button></span>
			</span>
		</div>
		<table class="tbl-ex emp-tbl">
			<summary>총 직원수 : 25</summary>
			<thead>
				<tr class="search-tr">
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
				</tr>
			<thead>
				<tr class="title-tr">
					<th>본부</th>
					<th>부서</th>
					<th>사번</th>
					<th>이름</th>
					<th>직급</th>
					<th>내선번호</th>
					<th>이메일</th>
					<th>액세스권한</th>
				</tr>
			</thead>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>IT본부</td>
					<td>${list.emp_dept}</td>
					<td>${list.emp_id}</td>
					<td>${list.emp_name}</td>
					<td>${list.emp_posi}</td>
					<td>${list.emp_tel}</td>
					<td>${list.emp_email}</td>
					<c:if test="${list.emp_level=='1'}">
						<td>관리자</td>
					</c:if>
					<c:if test="${list.emp_level!='1'}">
						<td>직원</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</main>
</div>