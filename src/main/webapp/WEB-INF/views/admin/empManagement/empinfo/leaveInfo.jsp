<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/update_memberinfo.css">
<link rel="stylesheet" href="/css/component_board.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<th></th>
					<th><input type="text" class="search" placeholder="검색.."></th>
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
					<th></th>
					<th>부서</th>
					<th>사번</th>
					<th>이름</th>
					<th>직급</th>
					<th>총연차</th>
					<th>사용연차</th>
					<th>잔여연차</th>
					<th>입사일</th>
					<th>퇴사일</th>
				</tr>
			</thead>
			<c:forEach var="list" items="${list}">
				<tr>
					<td><input type="checkbox" id="empCheck"></td>
					<td>${list.emp_dept}</td>
					<td>${list.emp_id}</td>
					<td>${list.emp_name}</td>
					<td>${list.emp_posi}</td>
					<td>${list.total_annday}</td>
					<td>${list.annday_used}</td>
					<td>${list.annday_rest}</td>
					<td>${list.emp_join}</td>
					<td>${list.emp_resi}</td>
				</tr>
			</c:forEach>
		</table>
		
		<c:set var ="page" value="${(empty param.p)?1:param.p}"/> <!-- p는 쿼리스트링으로 넘겨준 p 아래참고 -->
		<c:set var="startNum" value="${page-(page-1)%5}" />
		<!-- el태그안에서 나누기 연산, 실수값으로 변환 -->
		<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(cnt/10),'.')}" />
		<div class="indexer align-right">
			<div>
				<span class="text-imp text-strong">${(empty param.p)?1:param.p}</span>
				/ ${lastNum} pages
			</div>
		</div>
		<div class="align-center pager">
			<div>
				<c:if test="${startNum>1}">
					<a href="?p=${startNum-1}" class="btn btn-next">이전</a>
				</c:if>
				<c:if test="${startNum<=1}">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>
			</div>
			<ul class="pages center">
				<c:forEach var="i" begin="0" end="4">
					<!-- 큰따옴표 안에서 el안 큰따옴표 쓸수 없음. 작은따옴표 &f=${param.f}&q=${param.q}-->
					<c:if test="${(startNum+i) <= lastNum}">
						<li><a class="${(page==(startNum+i))?'imp':''} bold"	href="?p=${startNum+i}">${startNum+i}</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<div>
				<!-- el태그를 통해서 연산 -->
				<c:if test="${startNum+5<=lastNum}">
					<a href="?p=${startNum+5}" class="btn btn-next">다음</a>
				</c:if>
				<c:if test="${startNum+5>lastNum}">
					<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>
			</div>
		</div>
	</main>
</div>