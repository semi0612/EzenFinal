<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/vacRequestManage.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="content-wrapper">
	<main>
		<h2>휴가요청관리 - 모든 요청</h2>
		<div class="sub-tab">
			<span class="tab-group1 btns3">
				<!-- <h4>직원정보</h4> -->
				<span class="wrap"><a href="confirmAll" onclick="return confirm('선택한 요청을 일괄승인 하시겠습니까?')"><button class="button-three">일괄승인</button></a></span>
				<span class="wrap"><a href="rejectAll" onclick="return confirm('선택한 요청을 일괄거절 하시겠습니까?')"><button class="button-three">일괄거절</button></a></span>
				<span class="wrap"><button class="button-two" onclick="location.href='all'">모든 내역</button></span>
				<!-- <span class="wrap"><button class="button-two" onclick="location.href='all'">모든 내역</button></span> --> 
			</span>
		</div>
		<table class="tbl-ex emp-tbl check">
			<summary>대기중 요청 : ${cnt}</summary>
			<thead>
				<tr class="title-tr">
					<th></th>
					<th>요청번호</th>
					<th>부서</th>
					<th>사번</th>
					<th>직원</th>
					<th>휴가기간</th>
					<th>휴가사유</th>
					<th>휴가종류</th>
					<th>증빙파일</th>
					<th>요청상태</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="vac" items="${vacList}">
				<tr>
					<td><input type="checkbox"></td>
					<td>${vac.holi_rid}</td>
					<td>${vac.org_teamname}</td>
					<td>${vac.emp_id}</td>
					<td>${vac.emp_name}</td>
					<td>
						<c:set var="period" value="${vac.holi_period}"/>
						<c:set var="len" value="${fn:length(period)}"/>
						<c:set var="days" value="${fn:substring(period,0,(len-3))}"/>
						<c:set var="cnt" value="${fn:substring(period,(len-2),len-1)}"/>
						${days} <b style="color:var(--imp-color)">(${cnt}일)</b>
					</td>
					<td>${vac.holi_res}</td>
					<td>${vac.holi_code}</td>
					<c:set var="style" value="font-weight:500;"/>
					<td><a download href="/upload/${vac.holi_evi}" style="${style}">${vac.holi_evi}</a></td>
					<td>${vac.holi_state}</td>
					<td>
						<!-- 승인 전에만 취소 가능 -->
						<form action="confirm?id=${vac.holi_rid}&emp_id=${vac.emp_id}">
							<button class="button-two" type="submit" onclick="return confirm('해당 요청을 승인하시겠습니까?');">승인</button>
						</form>
						<form action="reject?id=${vac.holi_rid}">
							<button class="button-two" type="submit" onclick="return confirm('해당 요청을 거절하시겠습니까?');">거절</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</main>
</div>