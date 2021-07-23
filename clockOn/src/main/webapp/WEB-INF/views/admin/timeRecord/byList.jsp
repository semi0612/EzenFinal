<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/scroll_board.css">
<script type="text/javascript" src="/js/search_list.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<main>
		<h2>출근 리스트</h2>
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
					<th></th>
					<th><input type="text" class="search" id="work_day" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th><input type="text" class="search" id="emp_name" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th><input type="text" class="search" id="org_teamname" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th></th>
					<th></th>
					<th></th>
					<th><input type="text" class="search" id="work_comm" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th></th>
				</tr>
			<!-- select work_rid, work_date, emp_name, org_teamname as emp_dept, work_in, work_out, work_comm  -->
				<tr class="title-tr">
					<th class="NO">No</th> <!-- work_rid -->
					<th class="DATE">Date</th> <!-- work_date -->
					<th class="ENAME">직원</th> <!-- emp_name -->
					<th class="TNAME">부서</th> <!-- emp_dept --> <!-- Date, 7/17 -->
					<th class="INTIME">출근시각</th> <!-- work_in -->
					<th class="ENDTIME">퇴근시각</th> <!-- work_out -->
					<th class="TOTIME">근무시간</th> <!-- workingTime-->
					<th class="COMM">비고</th> <!-- WORK_COMM -->
					<th class="REQUEST">요청</th>
				</tr>
			</thead>
			<tbody id="ajax">
			<%-- <c:forEach var="list" items="${list}">
				<tr>
					<td>${list.work_rid}</td>
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

<script type="text/javascript" src="/js/admin_byList.js"></script>