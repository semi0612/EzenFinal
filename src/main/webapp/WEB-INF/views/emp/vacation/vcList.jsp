<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/component_board.css">
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/request_vacation.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="content-wrapper">
	<main>
		<h2>휴가요청</h2>
		<div class="sub-tab">
			<span class="tab-group1 btns3">
				<!-- <h4>직원정보</h4> -->
				<span class="wrap"><button class="button-three" onclick="location.href='request'">휴가신청</button></span>
				<!-- <span class="wrap"><button class="button-two" onclick="location.href='corrInfo'">기간 설정</button></span> --> 
			</span>
		</div>
		<table class="tbl-ex emp-tbl">
			<summary>총 연차 : ${annday.total_annday} 잔여연차 : ${annday.annday_rest}</summary>
			<thead>
				<tr class="title-tr">
					<th>요청번호</th>
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
					<td>${vac.holi_rid}</td>
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
						<c:if test="${vac.holi_state == '대기'}">
							<a href="cancelVacReq?id=${vac.holi_rid}" onclick="return confirm('해당 요청을 취소하시겠습니까?');">
								<button class="button-two">취소</button>
							</a>
						</c:if>
						<c:if test="${vac.holi_state == '승인'}">
							취소불가
						</c:if>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</main>
</div>