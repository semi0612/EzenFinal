<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/component_boardInScroll.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/leave_list.js"></script>
<script type="text/javascript" src="/js/paging.js"></script>
<div class="content-wrapper">
	<main>
		<h2>연차정보관리</h2>
		<div class="sub-tab">
			<span class="tab-group1">
				<h4>서브메뉴</h4> <span class="wrap"><button class="button-three" onclick="location.href='memberlist'">기본정보</button></span>
				<span class="wrap"><button class="button-three" onclick="location.href='salaryInfo'">급여</button></span>
			</span> <span class="tab-group2">
				<h4>연차정보</h4> <span class="wrap"><button class="button-two">일괄수정</button></span>
				<span class="wrap"><button class="button-two">수정</button></span> <span
				class="wrap"><button class="button-two">삭제</button></span>
			</span>
		</div>
		<table class="tbl-ex emp-tbl">
			<summary>총 직원수 : ${cnt}</summary>
			<thead>
				<tr class="search-tr">
					<th class="chk"></th>
					<th class="tname"><input type="text" class="search" id="org_teamname" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="eid"><input type="text" class="search" id="emp_id" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="ename"><input type="text" class="search" id="emp_name" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="eposi"><input type="text" class="search" id="emp_posi" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="total"><input type="text" class="search" id="total_annday" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="rest"><input type="text" class="search" id="annday_rest" onkeyup="getMap(1)" placeholder="검색.."></th>
					<th class="rest_op"><select id="upDown"  onchange="getMap(1)"><option value="up">이상</option><option value="down">이하</option></select></th>
					<th class="ejoin"><input type="date" class="search" id="emp_join" onchange="getMap(1)" placeholder="검색.."></th>
					<th class="ejoin_op"><select id="beforeAfter" onchange="getMap(1)"><option value="before">이전</option><option value="after">이후</option></select></th>
				</tr>
			<thead>
				<tr class="title-tr">
					<th class="chk"></th>
					<th class="tname">부서</th>
					<th class="eid">사번</th>
					<th class="ename">이름</th>
					<th class="eposi">직급</th>
					<th class="total">총연차</th>
					<th class="rest">잔여연차</th>
					<th class="used">사용연차</th>
					<th class="ejoin">입사일</th>
					<th class="exit">퇴사일</th>
				</tr>
			</thead>
			<tbody id="ajax">
			</tbody>
		</table>
	</main>
</div>