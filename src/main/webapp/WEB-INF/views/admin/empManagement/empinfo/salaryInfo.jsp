<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/component_boardInScroll.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/salary_list.js"></script>
<script type="text/javascript" src="/js/paging.js"></script>
<div class="content-wrapper">
	<main>
		<h2>직원급여관리</h2>
		<div class="sub-tab">
			<span class="tab-group1">
				<h4>서브메뉴</h4> <span class="wrap"><button class="button-three" onclick="location.href='memberlist'">기본정보</button></span>
				<span class="wrap"><button class="button-three" onclick="location.href='leaveInfo'">연차</button></span>
			</span> <span class="tab-group2">
				<h4>급여정보</h4> <span class="wrap"><button class="button-two">일괄수정</button></span>
				<span class="wrap"><button class="button-two">수정</button></span> <span
				class="wrap"><button class="button-two">삭제</button></span>
			</span>
		</div>
		<table class="tbl-ex emp-tbl sal-tab">
			<summary>총 직원수 : ${cnt}</summary>
			<thead>
				<tr class="search-tr">
					<th class="chk"></th>
					<th class="gname"><input type="text" id="org_groupname" class="search" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="tname"><input type="text" id="org_teamname" class="search" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="eid"><input type="text" id="emp_id" class="search" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="ename"><input type="text" id="emp_name" class="search" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="eposi"><input type="text" id="emp_posi" class="search" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="esal"><input type="text" id="emp_sal" class="search" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="esal_op"><select id="upDown"  onchange="getMap(1)"><option value="up">이상</option><option value="down">이하</option></select></th>
					<th class="ejoin"><input type="date" id="emp_join" class="search" onchange="getMap(1)" placeholder="검색.."></th>
					<th class="ejoin_op"><select id="beforeAfter" onchange="getMap(1)"><option value="before">이전</option><option value="after">이후</option></select></th>
				</tr>
			<thead>
				<tr class="title-tr">
					<th class="chk"></th>
					<th class="gname">본부</th>
					<th class="tname">부서</th>
					<th class="eid">사번</th>
					<th class="ename">이름</th>
					<th class="eposi">직급</th>
					<th class="esal">연봉</th>
					<th class="monthly">월급</th>
					<th class="ejoin">입사일</th>
					<th class="exit">퇴사일</th>
				</tr>
			</thead>
			<tbody id="ajax">
			<%-- <c:forEach var="list" items="${list}">
				<tr>
					<td><input type="checkbox" id="empCheck"></td>
					<td>${list.org_groupname}</td>
					<td>${list.emp_dept}</td>
					<td>${list.emp_id}</td>
					<td>${list.emp_name}</td>
					<td>${list.emp_posi}</td>
					<td>${list.emp_sal}</td>
					<td>${list.emp_pay}</td>
					<td>${list.emp_join}</td>
					<td>${list.emp_resi}</td>
				</tr>
			</c:forEach> --%>
			</tbody>
		</table>
	</main>
</div>