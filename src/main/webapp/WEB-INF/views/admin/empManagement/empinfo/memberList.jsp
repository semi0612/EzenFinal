<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/component_boardInScroll.css">
<script type="text/javascript" src="/js/search_list.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<main>
		<h2>직원정보관리</h2>
		<div class="sub-tab">
			<span class="tab-group1">
				<h4>서브메뉴</h4> <span class="wrap"><button class="button-three" onclick="location.href='leaveInfo'">연차</button></span>
				<span class="wrap"><button class="button-three" onclick="location.href='salaryInfo'">급여</button></span>
			</span> <span class="tab-group2">
				<h4>직원정보</h4> <span class="wrap"><button class="button-two" onclick="location.href='addMember'">직원추가</button></span>
				<span class="wrap"><button class="button-two" onclick="location.href='corrInfo'">수정</button></span> <span
				class="wrap"><button class="button-two">삭제</button></span>
			</span>
		</div>
		<table class="tbl-ex emp-tbl">
			<summary>총 직원수 : ${cnt} &nbsp; <span id="totRows"></span></summary>
			<thead>
				<tr class="search-tr">
					<th class="gname"><input type="text" class="search" id="org_groupname" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="tname"><input type="text" class="search" id="org_teamname" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="eid"><input type="text" class="search" id="emp_id" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="ename"><input type="text" class="search" id="emp_name" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="eposi"><input type="text" class="search" id="emp_posi" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="etel"><input type="text" class="search" id="emp_tel" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="email"><input type="text" class="search" id="emp_email" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="elevel"><input type="text" class="search" id="emp_level" onkeyup="getMap(1)" placeholder="admin/member"></th>
				</tr>
				<tr class="title-tr">
					<th class="gname">본부</th>
					<th class="tname">부서</th>
					<th class="eid">사번</th>
					<th class="ename">이름</th>
					<th class="eposi">직급</th>
					<th class="etel">내선번호</th>
					<th class="email">이메일</th>
					<th class="elevel">액세스권한</th>
				</tr>
			</thead>
			<tbody id="ajax">
			<%-- <c:forEach var="list" items="${list}">
				<tr>
					<td>${list.org_groupname}</td>
					<td>${list.emp_dept}</td>
					<td>${list.emp_id}</td>
					<td>${list.emp_name}</td>
					<td>${list.emp_posi}</td>
					<td>${list.emp_tel}</td>
					<td>${list.emp_email}</td>
					<c:if test="${list.emp_level=='ROLE_ADMIN'}">
						<td>관리자</td>
					</c:if>
					<c:if test="${list.emp_level=='ROLE_MEMBER'}">
						<td>직원</td>
					</c:if>
				</tr>
			</c:forEach> --%>
			</tbody>
		</table>
	</main>
</div>
