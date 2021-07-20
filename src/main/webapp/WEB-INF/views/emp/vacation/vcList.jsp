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
			<summary>총 연차 : ${annday.total_annday} &nbsp; | &nbsp; 잔여연차 : ${annday.annday_rest} &nbsp;|&nbsp; 신청 가능 연차 : ${annday.annday_rest - cntwoff} </summary>
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
					<td>${vac.holi_period} <b style="color:var(--imp-color)">(${vac.holi_cnt}일)</b></td>
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
		<div class="indexer align-right">
			<div>
				<span class="text-imp text-strong">${pg.page==''?1:pg.page}</span>
				/ ${pg.lastNum} pages
			</div>
		</div>
		<div class="align-center pager">
			<div>
				<c:if test="${pg.startNum>1}">
					<a href="?p=${pg.startNum-1}" class="btn btn-next">이전</a>
				</c:if>
				<c:if test="${pg.startNum<=1}">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>
			</div>
			<ul class="pages center">
				<c:forEach var="i" begin="0" end="4">
					<!-- 큰따옴표 안에서 el안 큰따옴표 쓸수 없음. 작은따옴표 &f=${param.f}&q=${param.q}-->
					<c:if test="${(pg.startNum+i) <= pg.lastNum}">
						<li><a class="${(pg.page==(pg.startNum+i))?'imp':''} bold" href="?p=${pg.startNum+i}">${pg.startNum+i}</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<div>
				<!-- el태그를 통해서 연산 -->
				<c:if test="${pg.startNum+5<=pg.lastNum}">
					<a href="?p=${pg.startNum+5}" class="btn btn-next">다음</a>
				</c:if>
				<c:if test="${pg.startNum+5>pg.lastNum}">
					<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>
			</div>
		</div>
	</main>
</div>