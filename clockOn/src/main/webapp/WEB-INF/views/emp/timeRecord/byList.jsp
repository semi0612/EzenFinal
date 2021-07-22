<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
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
			<summary>총 직원수 : ${cnt}</summary>
			<thead>
				<tr class="search-tr">
					<th></th>
					<th><input type="text" class="search" id="work_day" onkeyup="getMap()" placeholder="검색.."></th>
					<th></th>
					<th></th>
					<th><input type="text" class="search" id="workingTime" onkeyup="getMap()" placeholder="검색.."></th>
					<th><input type="text" class="search" id="work_comm" onkeyup="getMap()" placeholder="검색.."></th>
					<th></th>
				</tr>
			<thead>
				<tr class="title-tr">
					<th>No</th> <!-- work_rid -->
					<th>Date</th> <!-- work_date -->
					<th>출근시각</th> <!-- work_in -->
					<th>퇴근시각</th> <!-- work_out -->
					<th>근무시간</th> <!-- workingTime-->
					<th>비고</th> <!-- WORK_COMM -->
					<th>요청</th>
				</tr>
			</thead>
			<tbody id="ajax">

			</tbody>
		</table>
	</main>
</div>
<script type="text/javascript" src="/js/emp_byList.js"></script>